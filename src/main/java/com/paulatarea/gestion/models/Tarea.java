package com.paulatarea.gestion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.List;

@Entity
@Table(name = "tarea_gestion")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tareaId;

    @Column(name ="titulo")
    @NotNull
    private String tareaTitulo;

    @Column(name ="descripcion")
    @NotNull
    private String tareaDescripcion;

    @Column(name = "fecha_maxima")
    @NotNull
    private Integer tareaFecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    //Creamos el atributo que corresponde a un objeto de clase Curso
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL)
    private List<Comentario> comentariosTarea;
}
