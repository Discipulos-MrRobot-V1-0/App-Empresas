package com.discipulosMrRobot.demo.Service.Impl;

import com.discipulosMrRobot.demo.Repository.IMovimientoRepository;
import com.discipulosMrRobot.demo.Service.IMovimientoService;
import com.discipulosMrRobot.demo.model.MovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServiceImpl  implements IMovimientoService {
    @Autowired
    private IMovimientoRepository repo;

    @Override
    public MovimientoDinero create(MovimientoDinero movimientoDinero) throws Exception {
        return repo.save(movimientoDinero);
    }

    @Override
    public MovimientoDinero update(MovimientoDinero movimientoDinero) throws Exception {
        return repo.save(movimientoDinero);
    }

    @Override
    public List<MovimientoDinero> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public MovimientoDinero readById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);

    }


}
