package com.discipulosMrRobot.demo.Service;

import com.discipulosMrRobot.demo.model.Empleado;
import com.discipulosMrRobot.demo.model.Empresa;

import java.util.List;

public interface IEmpresaService {
    Empresa create(Empresa empresa) throws Exception;
    Empresa update(Empresa empresa) throws Exception;
    List<Empresa> readAll() throws Exception;
    Empresa readById(Integer id) throws Exception;
    void delete (Integer id) throws Exception;

    //Empresa saveTransactional(Empresa empresa, List<Empleado> empleados);
}
