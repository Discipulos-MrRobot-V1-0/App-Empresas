package com.discipulosMrRobot.demo.Repository;

import com.discipulosMrRobot.demo.model2.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerfilRepository extends JpaRepository<Perfil,Integer> {
}
