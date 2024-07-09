package com.alura.ChallengeForoHub.Record.Curso;

import com.alura.ChallengeForoHub.Model.Curso;

public record DatosListadoCurso(
        Long id,
        String nombre,
        String categoria
) {

    public DatosListadoCurso(Curso curso) {
        this(curso.getCursoId(), curso.getNombre(), curso.getCategoria());
    }

}
