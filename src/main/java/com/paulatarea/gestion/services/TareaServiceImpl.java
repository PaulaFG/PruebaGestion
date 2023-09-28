package com.paulatarea.gestion.services;

import com.paulatarea.gestion.models.Tarea;
import com.paulatarea.gestion.models.Usuario;
import com.paulatarea.gestion.repositories.ComentarioRepository;
import com.paulatarea.gestion.repositories.TareaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TareaServiceImpl implements TareaService{
    @Autowired
    TareaRepository tareaRepository;

    @Override
    public List<Tarea> listaDeTareas()  {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea buscarTareaPorId(Long id) {
        Boolean existe = tareaRepository.existsById(id);

        if (existe) {
            Tarea tareaEscogida = tareaRepository.findById(id).get();
            return tareaEscogida;
        } else {
            System.out.println("El id es inválido o no existe");
            return null;
        }
    }

    @Override
    public Tarea guardarTarea(Tarea tareaNuevo) {
        return tareaRepository.save(tareaNuevo);
    }

    @Override
    public void borrarTarea(Long id) {
        tareaRepository.deleteById(id);

    }

    @Override
    public Tarea editarTareaPorId(Long id, Tarea tareaActualizada) {
        Boolean existe = tareaRepository.existsById(id);

        if (existe) {
            Tarea tareaSeleccionada = tareaRepository.findById(id).get();
            tareaSeleccionada.setTareaTitulo(tareaActualizada.getTareaTitulo());
            tareaSeleccionada.setTareaDescripcion(tareaActualizada.getTareaDescripcion());
            tareaSeleccionada.setTareaFecha(tareaActualizada.getTareaFecha());
            System.out.println("La tarea ha sido actualizada");
            return tareaRepository.save(tareaSeleccionada);
        } else {
            System.out.println("La tarea no existe o el id es inválido");
            return null;
        }
    }
}
