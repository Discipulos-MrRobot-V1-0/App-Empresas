package com.discipulosMrRobot.demo.Controller;

import com.discipulosMrRobot.demo.Service.IMovimientoService;
import com.discipulosMrRobot.demo.model2.MovimientoDinero;
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
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    private IMovimientoService service;

    @GetMapping
    public List<MovimientoDinero> readAll() throws Exception{
        return service.readAll();
    }

    @PostMapping
    public MovimientoDinero create(@RequestBody MovimientoDinero movimientoDinero) throws Exception{
        return service.create(movimientoDinero);
    }

    @GetMapping("/{id}")
    public MovimientoDinero readById(@PathVariable("id") Integer id) throws Exception{
        return service.readById(id);
    }

    @PatchMapping("/{id}")
    public MovimientoDinero update(@RequestBody MovimientoDinero movimiento, @PathVariable("id") Integer id) throws Exception{
        MovimientoDinero newMovimiento = service.readById(id);
        newMovimiento.setMonto(movimiento.getMonto());
        newMovimiento.setConcepto(movimiento.getConcepto());
        return service.update(newMovimiento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
