package com.paulatarea.gestion.services;

import com.paulatarea.gestion.models.Comentario;

import java.util.List;

public interface ComentarioService {
    List<Comentario> listaDeComentarios();

    Comentario buscarComentarioPorId(Long id);

    Comentario guardarComentario(Comentario comentarioNuevo);

    void borrarComentario(Long id);

    Comentario editarComentarioPorId(Long id, Comentario comentarioActualizado);
}
