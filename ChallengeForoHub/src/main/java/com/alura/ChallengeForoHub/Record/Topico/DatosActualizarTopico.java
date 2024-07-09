package com.alura.ChallengeForoHub.Record.Topico;

import com.alura.ChallengeForoHub.Model.StatusTopico;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        StatusTopico estado,
        Long autor,
        Long curso
) {
}
