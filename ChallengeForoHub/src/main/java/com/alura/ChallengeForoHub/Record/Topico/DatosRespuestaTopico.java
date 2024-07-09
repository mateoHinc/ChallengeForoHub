package com.alura.ChallengeForoHub.Record.Topico;

import com.alura.ChallengeForoHub.Model.StatusTopico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico estado,
        Long autor,
        Long curso
) {
}
