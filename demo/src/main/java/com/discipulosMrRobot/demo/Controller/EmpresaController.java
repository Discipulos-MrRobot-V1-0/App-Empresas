package com.discipulosMrRobot.demo.Controller;

import com.discipulosMrRobot.demo.Service.IEmpresaService;
import com.discipulosMrRobot.demo.model2.Empresa;
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
@RequestMapping("/empresas")
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

    @GetMapping("/{id}")
    public Empresa readById(@PathVariable("id") Integer id) throws Exception{
        return service.readById(id);
    }

    @PatchMapping("/{id}")
    public Empresa update(@RequestBody Empresa empresa, @PathVariable("id") Integer id) throws Exception{
        Empresa newEmpresa = service.readById(id);
        newEmpresa.setNombreEmpresa(empresa.getNombreEmpresa());
        newEmpresa.setDireccion(empresa.getDireccion());
        newEmpresa.setTelefono(empresa.getTelefono());
        newEmpresa.setNit(empresa.getNit());
        return service.update(newEmpresa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }

}
