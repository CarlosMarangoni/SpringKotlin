package br.alura.forum.dto

import br.alura.forum.model.StatusTopico
import java.time.LocalDateTime

data class TopicoView (
    val id:Long?,
    val titulo:String,
    val mensagem:String,
    val status:StatusTopico,
    val dataCriacao: LocalDateTime
        )
