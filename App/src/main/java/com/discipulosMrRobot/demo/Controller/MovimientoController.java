package com.discipulosMrRobot.demo.Controller;

import com.discipulosMrRobot.demo.Dto.MovimientoDTO;
import com.discipulosMrRobot.demo.Service.IMovimientoService;
import com.discipulosMrRobot.demo.model.MovimientoDinero;
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
@RequestMapping("/movimiento")
public class MovimientoController {
    @Autowired
    private IMovimientoService service;

    @Autowired
    @Qualifier("movimientoMapper")
    private ModelMapper mapper;

    @GetMapping
    public List<MovimientoDinero> readAll() throws Exception{
        return service.readAll();
    }

    @GetMapping("/{id}")
    public MovimientoDinero readById(@PathVariable("id") Integer id) throws Exception{
        return service.readById(id);
    }

    @GetMapping("empresa/{id}")
    public ResponseEntity<List<MovimientoDTO>> readMovementsByIdEnterprise(@PathVariable("id") Integer id) throws Exception{
        List<MovimientoDTO> movimientos = service.readAll().stream()
                .map(mov -> mapper.map(mov, MovimientoDTO.class))
                .filter(mov -> (int) mov.getIdEmpresa() == (int) id)
                .collect(Collectors.toList());
        return new ResponseEntity<>(movimientos, HttpStatus.OK);
    }

    @PostMapping("empresa/{id}")
    public ResponseEntity<MovimientoDTO> create(@Valid @RequestBody MovimientoDTO movimientoDTO, @PathVariable("id") Integer id) throws Exception {
        movimientoDTO.setFechaCreacion(LocalDateTime.now());
        movimientoDTO.setFechaModificacion(LocalDateTime.now());
        movimientoDTO.setIdEmpresa(id);
        MovimientoDinero movimiento = service.create(mapper.map(movimientoDTO, MovimientoDinero.class));
        MovimientoDTO dto = mapper.map(movimiento, MovimientoDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PatchMapping("empresa/{id}")
    public ResponseEntity<MovimientoDTO> update(@Valid @RequestBody MovimientoDTO movimientoDTO, @PathVariable("id") Integer id) throws Exception {
        MovimientoDinero movimiento = service.readById(id);
        if(movimiento != null){
            movimientoDTO.setFechaModificacion(LocalDateTime.now());
            movimientoDTO.setFechaCreacion(movimiento.getFechaCreacion());
            movimientoDTO.setIdMovimiento(movimiento.getIdMovimiento());
            movimientoDTO.setIdEmpleado(movimiento.getEmpleado().getIdEmpleado());
            MovimientoDinero movimientoUpdated = service.update(mapper.map(movimientoDTO, MovimientoDinero.class));
            MovimientoDTO dto = mapper.map(movimientoUpdated, MovimientoDTO.class);
            return new ResponseEntity<>(dto,HttpStatus.OK);
        }
        else throw new Exception("Id no encontrado");
    }

    @DeleteMapping("empresa/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        MovimientoDinero movimiento = service.readById(id);
        if(movimiento == null) throw new Exception("Id movimiento no encontrado");
        else service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
