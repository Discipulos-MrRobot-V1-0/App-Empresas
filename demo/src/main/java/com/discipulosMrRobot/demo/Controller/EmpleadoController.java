package com.DiscipulosMrRobot.demo.controller;

import com.DiscipulosMrRobot.demo.model.Empleado;
import com.DiscipulosMrRobot.demo.model.Empresa;
import com.DiscipulosMrRobot.demo.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
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

    @GetMapping("/[id]")
    public Empleado readById(@PathVariable("id") Integer id) throws Exception{
        return service.readById(id);
    }

    @DeleteMapping("/[id]")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
