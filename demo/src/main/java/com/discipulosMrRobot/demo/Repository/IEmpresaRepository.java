package com.discipulosMrRobot.demo.Repository;

import com.discipulosMrRobot.demo.model2.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpresaRepository extends CrudRepository<Empresa,Integer> {

}
