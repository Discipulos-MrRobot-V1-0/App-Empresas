package com.discipulosMrRobot.demo.Repository;

import com.discipulosMrRobot.demo.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerfilRepository extends JpaRepository<Perfil,Integer> {
}
