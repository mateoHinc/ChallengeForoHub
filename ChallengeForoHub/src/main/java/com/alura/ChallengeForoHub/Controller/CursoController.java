package com.alura.ChallengeForoHub.Controller;

import com.alura.ChallengeForoHub.Model.Curso;
import com.alura.ChallengeForoHub.Record.Curso.DatosActualizarCurso;
import com.alura.ChallengeForoHub.Record.Curso.DatosListadoCurso;
import com.alura.ChallengeForoHub.Record.Curso.DatosRegistroCurso;
import com.alura.ChallengeForoHub.Record.Curso.DatosRespuestaCurso;
import com.alura.ChallengeForoHub.Repository.CursoRepository;
import com.alura.ChallengeForoHub.config.errores.TratadorErrores;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/foro/curso")
public class CursoController {

    private final CursoRepository cursoRepository;

    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaCurso> registrarUsuario(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso,
                                                                UriComponentsBuilder uriComponentsBuilder) {
        Curso curso = cursoRepository.save(new Curso(datosRegistroCurso));
        DatosRespuestaCurso datosRespuestaCurso = new DatosRespuestaCurso(
                curso.getCursoId(),
                curso.getNombre(),
                curso.getCategoria()
        );
        URI url = uriComponentsBuilder.path("/curso/{id}").buildAndExpand(curso.getCursoId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaCurso);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoCurso>> listadoCurso(@PageableDefault(size = 10, sort = "cursoId") Pageable paginacion) {
        return ResponseEntity.ok(cursoRepository.findAll(paginacion).map(DatosListadoCurso::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaCurso> RetornaDatosCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.getReferenceById(id);
        var datosCurso = new DatosRespuestaCurso(
                curso.getCursoId(),
                curso.getNombre(),
                curso.getCategoria()
        );
        return ResponseEntity.ok(datosCurso);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarCurso(@RequestBody @Valid DatosActualizarCurso datosActualizarCurso) {
        Curso curso = cursoRepository.getReferenceById(datosActualizarCurso.id());
        curso.actualizarDatos(datosActualizarCurso);
        return ResponseEntity.ok(new DatosRespuestaCurso(
                curso.getCursoId(),
                curso.getNombre(),
                curso.getCategoria()
        ));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarCurso(@PathVariable Long id) {
        if (cursoRepository.existsById(id)) {
            Curso curso = cursoRepository.getReferenceById(id);
            cursoRepository.delete(curso);
            return ResponseEntity.noContent().build();
        }
        return new TratadorErrores().tratarError404();
    }
}
