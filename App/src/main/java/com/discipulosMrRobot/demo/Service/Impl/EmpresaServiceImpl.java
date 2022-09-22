package com.discipulosMrRobot.demo.Service.Impl;

import com.discipulosMrRobot.demo.Repository.IEmpresaRepository;
import com.discipulosMrRobot.demo.Service.IEmpresaService;
import com.discipulosMrRobot.demo.model.Empleado;
import com.discipulosMrRobot.demo.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

    @Autowired
    private IEmpresaRepository repo;

    /*@Transactional
    @Override
    public Empresa saveTransactional(Empresa empresa, List<Empleado> empleados) {
        empleados.forEach(e -> e.setEmpresa(empresa));
        empresa.setEmpleados(empleados);
        return repo.save(empresa);
    }*/
    @Override
    public Empresa create(Empresa empresa) throws Exception {
        return repo.save(empresa);
    }

    @Override
    public Empresa update(Empresa empresa) throws Exception {
        return repo.save(empresa);
    }

    @Override
    public List<Empresa> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Empresa readById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) throws Exception {
    repo.deleteById(id);

    }
}
