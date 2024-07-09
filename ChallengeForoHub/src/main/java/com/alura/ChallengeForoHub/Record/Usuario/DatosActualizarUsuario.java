package com.alura.ChallengeForoHub.Record.Usuario;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(
        @NotNull
        Long id,
        String nombre,
        String email,
        String contrasena
) {
}
