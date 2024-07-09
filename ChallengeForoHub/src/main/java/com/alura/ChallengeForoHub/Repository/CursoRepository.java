package com.alura.ChallengeForoHub.Repository;

import com.alura.ChallengeForoHub.Model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
