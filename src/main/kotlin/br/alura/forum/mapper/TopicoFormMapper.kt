package br.alura.forum.mapper

import br.alura.forum.dto.NovoTopicoForm
import br.alura.forum.model.Topico
import br.alura.forum.service.CursoService
import br.alura.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
): Mapper<NovoTopicoForm,Topico>

 {


    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)

            )
    }

}
