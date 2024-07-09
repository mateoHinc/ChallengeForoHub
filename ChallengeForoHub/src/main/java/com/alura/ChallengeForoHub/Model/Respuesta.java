package com.alura.ChallengeForoHub.Model;

import com.alura.ChallengeForoHub.Record.Respuesta.DatosActualizarRespuesta;
import com.alura.ChallengeForoHub.Record.Respuesta.DatosRegistroRespuesta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Respuesta")
@Table(name = "respuestas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "respuesta_id")
    private Long respuestaId;

    @Column(name = "mensaje")
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Column(name = "solucion")
    private Boolean solucion = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    public Respuesta(DatosRegistroRespuesta datosRegistroRespuesta) {
        this.mensaje = datosRegistroRespuesta.mensaje();
        this.topico = new Topico(datosRegistroRespuesta.topico());
        this.autor = new Usuario(datosRegistroRespuesta.autor());
    }

    public void actualizarDatos(DatosActualizarRespuesta datosActualizarRespuesta) {
        if(datosActualizarRespuesta.mensaje() != null) {
            this.mensaje = datosActualizarRespuesta.mensaje();
        }

        if(datosActualizarRespuesta.solucion() != null) {
            this.solucion = datosActualizarRespuesta.solucion();
        }

        if(datosActualizarRespuesta.topico() != null) {
            this.topico = new Topico(datosActualizarRespuesta.topico());
        }

        if(datosActualizarRespuesta.autor() != null) {
            this.autor = new Usuario(datosActualizarRespuesta.autor());
        }
    }

}
