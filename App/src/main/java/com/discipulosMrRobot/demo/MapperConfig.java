package com.discipulosMrRobot.demo;

import com.discipulosMrRobot.demo.Dto.EmpleadoDTO;
import com.discipulosMrRobot.demo.Dto.PerfilDTO;
import com.discipulosMrRobot.demo.model.Empleado;
import com.discipulosMrRobot.demo.model.Perfil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

     @Bean("empresaMapper")
     public ModelMapper empresaMapper() {
          return new ModelMapper();
     }

     @Bean("empleadoMapper")
     public ModelMapper empleadoMapper() {
          ModelMapper mapper = new ModelMapper();
          TypeMap<EmpleadoDTO, Empleado> typeMap = mapper.createTypeMap(EmpleadoDTO.class, Empleado.class);
          typeMap.addMapping(src -> src.getIdEmpresa(), (dest, value) -> {
               if (value != null) dest.getEmpresa().setIdEmpresa((int) value);
               else dest.getEmpresa().setIdEmpresa(2);
          });
          return mapper;
     }

     @Bean("movimientoMapper")
     public ModelMapper movimientoMapper() {
          return new ModelMapper();
     }


     @Bean("perfilMapper")
     public ModelMapper perfilMapper() {
          ModelMapper mapper = new ModelMapper();
          TypeMap<PerfilDTO, Perfil> typeMap = mapper.createTypeMap(PerfilDTO.class, Perfil.class);
          typeMap.addMapping(src -> src.getIdEmpleado(), (dest, value) -> {
               if (value != null) dest.getEmpleado().setIdEmpleado((int) value);
               else dest.getEmpleado().setIdEmpleado(2);
          });
          return mapper;
     }
}

