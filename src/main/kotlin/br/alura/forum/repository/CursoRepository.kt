package br.alura.forum.repository

import br.alura.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<Curso,Long>{
}