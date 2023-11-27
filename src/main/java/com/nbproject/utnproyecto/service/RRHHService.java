package com.nbproject.utnproyecto.service;

import com.nbproject.utnproyecto.model.RRHH;
import com.nbproject.utnproyecto.repository.RRHHRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RRHHService {
    private RRHHRepository RRHHRepository;

    public RRHH addRRHH(RRHH rrhh){
        RRHH rrhh1 = null;
        rrhh1 = RRHHRepository.save(rrhh);
        return rrhh1;
    };

    public List<RRHH> getAllRRHH(){
        List<RRHH> listRRHH = RRHHRepository.findAll();
        return listRRHH;
    };

}
