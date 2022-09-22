package com.discipulosMrRobot.demo.Controller;

import com.discipulosMrRobot.demo.Dto.EmpleadoDTO;
import com.discipulosMrRobot.demo.Service.IEmpleadoService;
import com.discipulosMrRobot.demo.model.Empleado;
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
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService service;

    @Autowired
    @Qualifier("empleadoMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> readAll() throws Exception {
        List<EmpleadoDTO> empleados = service.readAll().stream()
                .map(c -> mapper.map(c, EmpleadoDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmpleadoDTO> create(@Valid @RequestBody EmpleadoDTO empleadoDTO) throws Exception {
        empleadoDTO.setFechaCreacion(LocalDateTime.now());
        empleadoDTO.setFechaModificacion(LocalDateTime.now());
        Empleado empleado = service.create(mapper.map(empleadoDTO, Empleado.class));
        EmpleadoDTO dto = mapper.map(empleado, EmpleadoDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Empleado empleado = service.readById(id);
        if(empleado == null)  throw new Exception("Id de empleado no encontrado");
        EmpleadoDTO dto = mapper.map(empleado, EmpleadoDTO.class);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> update(@Valid @RequestBody EmpleadoDTO empleadoDTO,@PathVariable("id") Integer id) throws Exception {
        Empleado empleado = service.readById(id);
        if(empleado != null){
            empleadoDTO.setFechaModificacion(LocalDateTime.now());
            empleadoDTO.setFechaCreacion(empleado.getFechaCreacion());
            empleadoDTO.setIdEmpleado(empleado.getIdEmpleado());
            Empleado empleadoUpdated = service.update(mapper.map(empleadoDTO, Empleado.class));
            EmpleadoDTO dto = mapper.map(empleadoUpdated, EmpleadoDTO.class);
            return new ResponseEntity<>(dto,HttpStatus.OK);
        }
        else throw new Exception("Id no encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        Empleado empleado = service.readById(id);
        if(empleado == null) throw new Exception("Id empleado no encontrado");
        else service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
