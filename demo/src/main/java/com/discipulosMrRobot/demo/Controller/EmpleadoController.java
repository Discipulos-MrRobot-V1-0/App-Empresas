package com.discipulosMrRobot.demo.Controller;

import com.discipulosMrRobot.demo.Service.IEmpleadoService;
import com.discipulosMrRobot.demo.model2.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService service;

    @GetMapping
    public List<Empleado> readAll() throws Exception{
        return service.readAll();
    }

    @PostMapping
    public Empleado create(@RequestBody Empleado empleado) throws Exception{
        return service.create(empleado);
    }

    @GetMapping("/{id}")
    public Empleado readById(@PathVariable("id") Integer id) throws Exception{
        return service.readById(id);
    }

    @PatchMapping("/{id}")
    public Empleado update(@RequestBody Empleado empleado, @PathVariable("id") Integer id) throws Exception{
        Empleado newEmpleado = service.readById(id);
        newEmpleado.setNombre(empleado.getNombre());
        newEmpleado.setCorreo(empleado.getCorreo());
        newEmpleado.setEmpresa(empleado.getEmpresa());
        newEmpleado.setRol(empleado.getRol());
        return service.update(newEmpleado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }

}
