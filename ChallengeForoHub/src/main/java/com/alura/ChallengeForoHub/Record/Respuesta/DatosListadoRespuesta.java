package com.alura.ChallengeForoHub.Record.Respuesta;

import com.alura.ChallengeForoHub.Model.Respuesta;

public record DatosListadoRespuesta(
        Long id,
        String mensaje,
        String fechaCreacion,
        Boolean solucion
) {

    public DatosListadoRespuesta(Respuesta respuesta) {
        this(respuesta.getRespuestaId(), respuesta.getMensaje(), respuesta.getFechaCreacion().toString(),respuesta.getSolucion());
    }

}
