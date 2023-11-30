package com.nbproject.utnproyecto.service;

import com.nbproject.utnproyecto.model.Especialidades_Tecnicos;
import com.nbproject.utnproyecto.model.Tecnicos;
import com.nbproject.utnproyecto.repository.Especialidades_TecnicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TecnicosService {

    @Autowired
    private Especialidades_TecnicosRepository especialidades_TecnicosRepository;

    public List<Tecnicos> findByEspecialidadIdEspecialidad(Integer idEspecialidad){
        List<Especialidades_Tecnicos> especialidades_TecnicosList = especialidades_TecnicosRepository.findByEspecialidad_IdEspecialidad(idEspecialidad);

        return especialidades_TecnicosList.stream().map(Especialidades_Tecnicos::getTecnico).collect(Collectors.toList());
    }
}

