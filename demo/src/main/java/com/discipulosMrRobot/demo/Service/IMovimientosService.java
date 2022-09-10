package com.DiscipulosMrRobot.demo.service;

import com.DiscipulosMrRobot.demo.model.MovimientoDinero;

import java.util.List;

public interface IMovimientosService {

    MovimientoDinero create(MovimientoDinero movimientoDinero) throws Exception;
    MovimientoDinero update(MovimientoDinero movimientoDinero) throws Exception;
    List<MovimientoDinero> readAll() throws Exception;
    MovimientoDinero readById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
