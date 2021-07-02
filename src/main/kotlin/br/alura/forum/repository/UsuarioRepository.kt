package br.alura.forum.repository

import br.alura.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario,Long>{
}