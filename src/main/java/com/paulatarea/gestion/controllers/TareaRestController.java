package com.paulatarea.gestion.controllers;

import com.paulatarea.gestion.models.Tarea;
import com.paulatarea.gestion.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
public class TareaRestController {
    @Autowired
    TareaService tareaService;


    @GetMapping("/lista")
    public List<Tarea> listadeTareas() {
        List<Tarea> listaMostrar = tareaService.listaDeTareas();
        return listaMostrar;
    }

    @GetMapping("/buscar/{id}")
    public Tarea tareaPorId(@PathVariable Long id) {
        Tarea tareaMostrar = tareaService.buscarTareaPorId(id);
        return tareaMostrar;
    }

    @PostMapping("/nuevo")
    public Tarea guardarNuevoTarea(@RequestBody Tarea TareaNuevo) {
        Tarea tareaParaGuardar = tareaService.guardarTarea(TareaNuevo);
        return tareaParaGuardar;
    }

    //Para borrar
    @DeleteMapping("/borrar")
    public String borrarTareaPorId(@RequestParam Long id) {
        tareaService.borrarTarea(id);
        return "La tarea ha sido borrada";
    }

    //Para editar
    @PutMapping("/editar/{id}")
    public Tarea editarTareaPorId(@PathVariable Long id,
                                  @RequestBody Tarea tareaActualizada) {
        Tarea tareaEditada = tareaService.editarTareaPorId(id,
                tareaActualizada);

        return tareaEditada;

    }
}