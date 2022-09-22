package com.discipulosMrRobot.demo.Repository;

import com.discipulosMrRobot.demo.model.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovimientoRepository extends JpaRepository<MovimientoDinero,Integer> {
}
