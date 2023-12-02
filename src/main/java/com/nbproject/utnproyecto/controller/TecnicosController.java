package com.nbproject.utnproyecto.controller;

import com.nbproject.utnproyecto.service.TecnicosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tecnicos")
public class TecnicosController {

    private final TecnicosService tecnicosService;

    @PostMapping("/actualizarTiempoResolucion")
    public void actualizarTiempoResolucion(@RequestParam Integer idIncidente, @RequestParam int nuevoTiempo) {
        tecnicosService.actualizarTiempoResolucion(idIncidente, nuevoTiempo);
    }

    /*
        Este ejemplo se puede utilizar si se ha creado previamente el incidente 3590, sino hay que revisar
        la base de datos y asignar resuelto en "0" para testear

        POSTMAN
        POST
        http://localhost:9090/serviciotecnico/tecnicos//actualizarTiempoResolucion?idIncidente=3590&nuevoTiempo=4

        El técnico se pone un colchón de horas. En realidad en lugar de sumar las horas suministradas,
        directamente establece la cantidad de horas que le va a tomar el trabajo para que sea algo diferente
        al otro método.

        Esto funcionará siempre y cuando el valor ingresado sea mayor al establecido en "tiempoResolucion" de
        la tabla incidentes

     */

    @PostMapping("/reducirTiempoResolucion")
    public ResponseEntity<String> reducirTiempoResolucion(@RequestParam Integer idIncidente, @RequestParam int nuevoTiempo) {
        ResponseEntity<String> response = tecnicosService.reducirTiempoResolucion(idIncidente, nuevoTiempo);

        return response;
    }

    /*

        Este ejemplo se puede utilizar si se ha creado previamente el incidente 3590, sino hay que revisar
        la base de datos y asignar resuelto en "0" para testear

        POSTMAN
        POST
        http://localhost:9090/serviciotecnico/tecnicos/reducirTiempoResolucion?idIncidente=3590&nuevoTiempo=2

        El técnico reduce la cantidad de horas siempre y cuando "resuelto" sea 0 y siempre y cuando las
        horas a reducir ingresadas sean menores (no igual) que el valor en "tiempoResolucion" de la tabla incidentes

        Por tanto si en "tiempoResolucion" dice 4 (horas), el valor 2 es correcto pero 5 o 4, no

        Si no cumple esto el mensaje será:
        No se cumplen las condiciones para reducir las horas de resolución para el incidente con ID: 3590

        Si se cumplen las condiciones:
        Horas de resolución reducidas con éxito para el incidente con ID: 3590

     */

    @PostMapping("/marcarComoResuelto/{idIncidente}")
    public ResponseEntity<String> marcarComoResuelto(@PathVariable Integer idIncidente, @RequestBody String consideraciones) {
        return tecnicosService.marcarComoResuelto(idIncidente, consideraciones);
    }
}
