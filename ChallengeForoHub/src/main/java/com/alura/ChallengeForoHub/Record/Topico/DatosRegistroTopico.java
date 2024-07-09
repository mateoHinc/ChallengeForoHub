package com.alura.ChallengeForoHub.Record.Topico;

import com.alura.ChallengeForoHub.Model.Curso;
import com.alura.ChallengeForoHub.Model.StatusTopico;
import com.alura.ChallengeForoHub.Model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        StatusTopico estado,
        @NotNull
        Long autor,
        @NotNull
        Long curso
) {
}
