package com.alura.ChallengeForoHub.Record.Usuario;

import com.alura.ChallengeForoHub.Model.Usuario;

public record DatosListadoUsuario(Long id, String nombre, String email) {

    public DatosListadoUsuario(Usuario usuario){
        this(usuario.getUsuarioId(), usuario.getNombre(), usuario.getEmail());
    }

}
