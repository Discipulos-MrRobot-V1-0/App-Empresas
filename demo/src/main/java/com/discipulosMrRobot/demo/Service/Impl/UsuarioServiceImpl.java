package com.DiscipulosMrRobot.demo.service.Impl;

import com.DiscipulosMrRobot.demo.model.Usuario;
import com.DiscipulosMrRobot.demo.repository.IUsuarioRepository;
import com.DiscipulosMrRobot.demo.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository repo;

    @Override
    public Usuario create(Usuario usuario) throws Exception {
        return repo.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) throws Exception {
        return repo.save(usuario);
    }

    @Override
    public List<Usuario> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Usuario readById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);

    }
}
