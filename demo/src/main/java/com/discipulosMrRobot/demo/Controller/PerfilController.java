package com.discipulosMrRobot.demo.Controller;

import com.discipulosMrRobot.demo.Service.IPerfilService;
import com.discipulosMrRobot.demo.model2.Perfil;
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
@RequestMapping("/perfiles")
public class PerfilController {
    @Autowired
    private IPerfilService service;

    @GetMapping
    public List<Perfil> readAll() throws Exception{
        return service.readAll();
    }

    @PostMapping
    public Perfil create(@RequestBody Perfil perfil) throws Exception{
        return service.create(perfil);
    }

    @GetMapping("/{id}")
    public Perfil readById(@PathVariable("id") Integer id) throws Exception{
        return service.readById(id);
    }

    @PatchMapping("/{id}")
    public Perfil update(@RequestBody Perfil perfil, @PathVariable("id") Integer id) throws Exception{
        Perfil newPerfil = service.readById(id);
        newPerfil.setImagen(perfil.getImagen());
        newPerfil.setTelefono(perfil.getTelefono());
        return service.update(newPerfil);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
