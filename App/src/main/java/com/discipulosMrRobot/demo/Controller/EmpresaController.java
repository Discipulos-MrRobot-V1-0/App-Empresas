package com.discipulosMrRobot.demo.Controller;

import com.discipulosMrRobot.demo.Dto.EmpresaDTO;
import com.discipulosMrRobot.demo.Service.IEmpresaService;
import com.discipulosMrRobot.demo.model.Empresa;
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

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private IEmpresaService service;

    @Autowired
    @Qualifier("empresaMapper")
    private ModelMapper mapper;


    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> readAll() throws Exception {
        List<EmpresaDTO> empresas = service.readAll().stream()
                .map(c -> mapper.map(c, EmpresaDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(empresas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmpresaDTO> create(@Valid @RequestBody EmpresaDTO empresaDTO) throws Exception {
        empresaDTO.setFechaCreacion(LocalDateTime.now());
        empresaDTO.setFechaModificacion(LocalDateTime.now());
        Empresa empresa = service.create(mapper.map(empresaDTO, Empresa.class));
        EmpresaDTO dto = mapper.map(empresa, EmpresaDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Empresa empresa = service.readById(id);
        if(empresa == null)  throw new Exception("Id de empresa no encontrado");
        EmpresaDTO dto = mapper.map(empresa, EmpresaDTO.class);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }



    @PatchMapping("/{id}")
    public ResponseEntity<EmpresaDTO> update(@Valid @RequestBody EmpresaDTO empresaDTO,@PathVariable("id") Integer id) throws Exception {
        Empresa empresa = service.readById(id);
        empresaDTO.setFechaModificacion(LocalDateTime.now());
        empresaDTO.setFechaCreacion(empresa.getFechaCreacion());
        empresaDTO.setIdEmpresa(empresa.getIdEmpresa());
        if(empresa != null){
            Empresa empresaUpdated = service.update(mapper.map(empresaDTO, Empresa.class));
            EmpresaDTO dto = mapper.map(empresaUpdated, EmpresaDTO.class);
            return new ResponseEntity<>(dto,HttpStatus.OK);
        }
        else throw new Exception("Id no encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        Empresa empresa = service.readById(id);
        if(empresa == null) throw new Exception("Id empresa no encontrado");
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
