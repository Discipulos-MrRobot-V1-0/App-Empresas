package com.discipulosMrRobot.demo.Repository;

import com.discipulosMrRobot.demo.model2.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa,Integer> {

}
