package br.alura.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NovoTopicoForm(


    @field:NotEmpty(message = "Titulo não0 pode estar em branco")
    @field:Size(min = 5,max = 100,message = "Titulo de ter entre 5 e 100 caracteres")
    val titulo:String,
    @field:NotEmpty
    val mensagem:String,
    @field:NotNull
    val idCurso:Long,
    @field:NotNull
    val idAutor:Long
)


