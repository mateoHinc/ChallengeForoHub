package com.alura.ChallengeForoHub.Model;

import com.alura.ChallengeForoHub.Record.Topico.DatosActualizarTopico;
import com.alura.ChallengeForoHub.Record.Topico.DatosRegistroTopico;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topico_id")
    private Long topicoId;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "mensaje")
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private StatusTopico estado = StatusTopico.NO_RESPONDIDO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private Set<Respuesta> respuestas = new HashSet<>();

    public Topico(Long topicoId){
        this.topicoId = topicoId;
    }

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.estado = datosRegistroTopico.estado();
        this.autor = new Usuario(datosRegistroTopico.autor());
        this.curso = new Curso(datosRegistroTopico.curso());
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }

        if(datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }

        if(datosActualizarTopico.estado() != null) {
            this.estado = datosActualizarTopico.estado();
        }

        if(datosActualizarTopico.autor() != null) {
            this.autor = new Usuario(datosActualizarTopico.autor());
        }

        if(datosActualizarTopico.curso() != null) {
            this.curso = new Curso(datosActualizarTopico.curso());
        }
    }
}
