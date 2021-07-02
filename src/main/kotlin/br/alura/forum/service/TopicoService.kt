package br.alura.forum.service

import br.alura.forum.exception.NotFoundException
import br.alura.forum.dto.AtualizacaoTopicoForm
import br.alura.forum.dto.NovoTopicoForm
import br.alura.forum.dto.TopicoView
import br.alura.forum.mapper.TopicoFormMapper
import br.alura.forum.mapper.TopicoViewMapper
import br.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage:String = "Tópico não encontrado"
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map { t->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val t = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return topicoViewMapper.map(t)

    }

    fun cadastrar(form: NovoTopicoForm):TopicoView{
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong()+1
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(topicoForm: AtualizacaoTopicoForm):TopicoView {
        val t = topicos.stream().filter { t ->
            t.id == topicoForm.id
        }.findFirst().get()

        val topicoAtualizado = Topico(
            id = topicoForm.id,
            titulo = topicoForm.titulo,
            mensagem = topicoForm.mensagem,
            autor = t.autor,
            curso = t.curso,
            respostas = t.respostas,
            status = t.status,
            dataCriacao = t.dataCriacao)
        topicos = topicos.minus(t).plus(topicoAtualizado)

        return topicoViewMapper.map(topicoAtualizado)
    }

    fun excluir(id: Long) {
        val t = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }

        topicos = topicos.minus(t)
    }


}