package com.alura.ChallengeForoHub.Record.Curso;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroCurso(
       @NotBlank
       String nombre,
       @NotBlank
       String categoria
) {
}
