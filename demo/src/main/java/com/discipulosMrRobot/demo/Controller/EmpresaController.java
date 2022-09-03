package com.discipulosMrRobot.demo.Controller;

import com.discipulosMrRobot.demo.Service.IEmpresaService;
import com.discipulosMrRobot.demo.model2.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private IEmpresaService service;

    @GetMapping
    public List<Empresa> readAll() throws Exception {
        return service.readAll();
    }

    @PostMapping
    public Empresa create(@RequestBody Empresa empresa) throws Exception {
        return service.create(empresa);
    }

}
