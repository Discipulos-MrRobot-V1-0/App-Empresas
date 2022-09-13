package com.discipulosMrRobot.demo.Service.Impl;

import com.discipulosMrRobot.demo.Repository.IEmpresaRepository;
import com.discipulosMrRobot.demo.Service.IEmpresaService;
import com.discipulosMrRobot.demo.model2.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

    @Autowired
    private IEmpresaRepository repo;

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
