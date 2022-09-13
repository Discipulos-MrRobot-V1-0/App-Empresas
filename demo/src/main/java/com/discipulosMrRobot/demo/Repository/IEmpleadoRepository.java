package com.discipulosMrRobot.demo.Repository;

import com.discipulosMrRobot.demo.model2.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado,Integer> {


}
