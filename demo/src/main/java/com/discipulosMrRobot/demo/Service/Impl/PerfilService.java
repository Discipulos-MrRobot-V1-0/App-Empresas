package com.discipulosMrRobot.demo.Service.Impl;

import com.discipulosMrRobot.demo.Repository.IMovimientoRepository;
import com.discipulosMrRobot.demo.Repository.IPerfilRepository;
import com.discipulosMrRobot.demo.Service.IPerfilService;
import com.discipulosMrRobot.demo.model2.MovimientoDinero;
import com.discipulosMrRobot.demo.model2.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService implements IPerfilService {

    @Autowired
    private IPerfilRepository repo;

    @Override
    public Perfil create(Perfil perfil) throws Exception {
        return repo.save(perfil);
    }

    @Override
    public Perfil update(Perfil perfil) throws Exception {
        return repo.save(perfil);
    }

    @Override
    public List<Perfil> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Perfil readById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
