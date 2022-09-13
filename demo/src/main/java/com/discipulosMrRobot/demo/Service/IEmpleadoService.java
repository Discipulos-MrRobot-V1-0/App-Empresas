package com.discipulosMrRobot.demo.Service;


import com.discipulosMrRobot.demo.model2.Empleado;
import com.discipulosMrRobot.demo.model2.Empresa;

import java.util.List;

public interface IEmpleadoService {

    Empleado create(Empleado empleado) throws Exception;
    Empleado update(Empleado empleado) throws Exception;
    List<Empleado> readAll() throws Exception;
    Empleado readById(Integer id) throws Exception;
    void delete (Integer id) throws Exception;
}
