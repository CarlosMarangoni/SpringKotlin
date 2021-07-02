package br.alura.forum.model

import java.time.LocalDateTime

data class Resposta (
    val id:Long? = null,
    val mensagem:String,
    val data:LocalDateTime = LocalDateTime.now(),
    val autor:Usuario,
    val topico:Topico,
    val solucao:Boolean

        )
