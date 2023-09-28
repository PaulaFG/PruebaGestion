package com.paulatarea.gestion.services;

import com.paulatarea.gestion.models.Tarea;

import java.util.List;

public interface TareaService {
    List<Tarea> listaDeTareas();

    Tarea buscarTareaPorId(Long id);

    Tarea guardarTarea(Tarea tareaNuevo);

    void borrarTarea(Long id);

    Tarea editarTareaPorId(Long id, Tarea tareaActualizado);
}
