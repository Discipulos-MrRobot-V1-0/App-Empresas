package com.discipulosMrRobot.demo.Controller;

import com.discipulosMrRobot.demo.Dto.PerfilDTO;
import com.discipulosMrRobot.demo.Service.IPerfilService;
import com.discipulosMrRobot.demo.model.Perfil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
    @Autowired
    private IPerfilService service;

    @Autowired
    @Qualifier("perfilMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<PerfilDTO>> readAll() throws Exception {
        List<PerfilDTO> perfiles = service.readAll().stream()
                .map(c -> mapper.map(c, PerfilDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(perfiles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PerfilDTO> create(@Valid @RequestBody PerfilDTO perfilDTO) throws Exception {
        perfilDTO.setFechaCreacion(LocalDateTime.now());
        perfilDTO.setFechaModificacion(LocalDateTime.now());
        Perfil perfil = service.create(mapper.map(perfilDTO, Perfil.class));
        PerfilDTO dto = mapper.map(perfil, PerfilDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Perfil perfil = service.readById(id);
        if(perfil == null)  throw new Exception("Id de perfil no encontrado");
        PerfilDTO dto = mapper.map(perfil, PerfilDTO.class);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PerfilDTO> update(@Valid @RequestBody PerfilDTO perfilDTO,@PathVariable("id") Integer id) throws Exception {
        Perfil perfil = service.readById(id);
        if(perfil != null){
            perfilDTO.setFechaModificacion(LocalDateTime.now());
            perfilDTO.setFechaCreacion(perfil.getFechaCreacion());
            perfilDTO.setIdPerfil(perfil.getIdPerfil());
            Perfil perfilUpdated = service.update(mapper.map(perfilDTO, Perfil.class));
            PerfilDTO dto = mapper.map(perfilUpdated, PerfilDTO.class);
            return new ResponseEntity<>(dto,HttpStatus.OK);
        }
        else throw new Exception("Id no encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        Perfil perfil = service.readById(id);
        if(perfil == null) throw new Exception("Id perfil no encontrado");
        else service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
