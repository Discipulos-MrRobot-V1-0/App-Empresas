package com.DiscipulosMrRobot.demo.controller;

import com.DiscipulosMrRobot.demo.model.MovimientoDinero;
import com.DiscipulosMrRobot.demo.service.IMovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa/[id]/movimientos")
public class MovimientosController {

    @Autowired
    private IMovimientosService service;

    @GetMapping
    public List<MovimientoDinero> readAll() throws Exception{
        return service.readAll();
    }

    @PostMapping
    public MovimientoDinero create(@RequestBody MovimientoDinero movimientoDinero) throws Exception{
        return service.create(movimientoDinero);
    }

    
}
