package com.discipulosMrRobot.demo.Service;

import com.discipulosMrRobot.demo.model2.MovimientoDinero;

import java.util.List;

public interface IMovimientoService {

    MovimientoDinero create(MovimientoDinero movimientoDinero) throws Exception;
    MovimientoDinero update(MovimientoDinero movimientoDinero) throws Exception;
    List<MovimientoDinero> readAll() throws Exception;
    MovimientoDinero readById(Integer id) throws Exception;
    void delete (Integer id) throws Exception;
}
