package com.paulatarea.gestion.services;

import com.paulatarea.gestion.models.Comentario;
import com.paulatarea.gestion.models.Tarea;
import com.paulatarea.gestion.repositories.ComentarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    ComentarioRepository comentarioRepository;
    @Override
    public List<Comentario> listaDeComentarios() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario buscarComentarioPorId(Long id) {
        Boolean existe = comentarioRepository.existsById(id);

        if (existe) {
            Comentario comentarioEscogida = comentarioRepository.findById(id).get();
            return comentarioEscogida;
        } else {
            System.out.println("El id es inválido o no existe");
            return null;
        }
    }

    @Override
    public Comentario guardarComentario(Comentario comentarioNuevo) {

        return comentarioRepository.save(comentarioNuevo);

    }

    @Override
    public void borrarComentario(Long id) {
        comentarioRepository.deleteById(id);

    }

    @Override
    public Comentario editarComentarioPorId(Long id, Comentario comentarioActualizado) {
        Boolean existe = comentarioRepository.existsById(id);

        if (existe) {
            Comentario comentarioSeleccionado = comentarioRepository.findById(id).get();
            comentarioSeleccionado.setComentarioFecha(comentarioActualizado.getComentarioFecha());
            comentarioSeleccionado.setComentarioTexto(comentarioActualizado.getComentarioTexto());
            System.out.println("El comentario ha sido actualizado");
            return comentarioRepository.save(comentarioSeleccionado);
        } else {
            System.out.println("El comentario no existe o el id es inválido");
            return null;
        }
    }

}
