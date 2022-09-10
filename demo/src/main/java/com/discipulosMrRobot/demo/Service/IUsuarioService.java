package com.DiscipulosMrRobot.demo.service;


import com.DiscipulosMrRobot.demo.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    Usuario create(Usuario usuario) throws Exception;
    Usuario update(Usuario usuario) throws Exception;
    List<Usuario> readAll() throws Exception;
    Usuario readById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
