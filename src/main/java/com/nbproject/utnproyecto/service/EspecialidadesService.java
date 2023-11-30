package com.nbproject.utnproyecto.service;

import com.nbproject.utnproyecto.model.Especialidades;
import com.nbproject.utnproyecto.repository.EspecialidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EspecialidadesService {

    @Autowired
    private EspecialidadesRepository especialidadesRepository;

    public Integer obtenerIdEspecialidad(int idAplicacion, int idEntorno){
        Optional<Especialidades> especialidadOptional = especialidadesRepository.findByAplicacionIdAplicacionAndEntornoIdEntorno(idAplicacion, idEntorno);

        if(especialidadOptional.isPresent()){
            return especialidadOptional.get().getIdEspecialidad();
        }else{
            return null;
        }
    }
}
