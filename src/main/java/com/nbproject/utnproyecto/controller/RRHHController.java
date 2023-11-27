package com.nbproject.utnproyecto.controller;

import com.nbproject.utnproyecto.model.RRHH;
import com.nbproject.utnproyecto.service.RRHHService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rrhh")
public class RRHHController {
    private RRHHService rrhhService;
    @PostMapping("/crear")
    public ResponseEntity<String> guardarRRHH(@RequestBody RRHH rrhh){
        rrhhService.addRRHH(rrhh);
        return ResponseEntity.ok("RRHH guardado con éxito");
    };

    @GetMapping("/todos")
    public ResponseEntity<Object> listarRRHH (){
        return ResponseEntity.ok(rrhhService.getAllRRHH());
    }

}
