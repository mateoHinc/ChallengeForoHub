package com.alura.ChallengeForoHub.Model;

import com.alura.ChallengeForoHub.Record.Curso.DatosActualizarCurso;
import com.alura.ChallengeForoHub.Record.Curso.DatosRegistroCurso;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Curso")
@Table(name = "cursos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id")
    private Long cursoId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "categoria")
    private String categoria;

    public Curso(Long cursoId) {
        this.cursoId = cursoId;
    }

    public Curso(DatosRegistroCurso datosRegistroCurso) {
        this.nombre = datosRegistroCurso.nombre();
        this.categoria = datosRegistroCurso.categoria();
    }

    public void actualizarDatos(DatosActualizarCurso datosActualizarCurso) {
        if(datosActualizarCurso.nombre() != null) {
            this.nombre = datosActualizarCurso.nombre();
        }
        if(datosActualizarCurso.categoria() != null) {
            this.categoria = datosActualizarCurso.categoria();
        }
    }

}
