package com.DiscipulosMrRobot.demo.repository;

import com.DiscipulosMrRobot.demo.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerfilRepository extends JpaRepository<Perfil,Integer> {
}
