package br.alura.forum.controller

import br.alura.forum.dto.AtualizacaoTopicoForm
import br.alura.forum.dto.NovoTopicoForm
import br.alura.forum.dto.TopicoView
import br.alura.forum.service.TopicoService
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val topicoService: TopicoService
) {



    @GetMapping
    fun listar():List<TopicoView>{
        return topicoService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id:Long):TopicoView{
        return topicoService.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid form: NovoTopicoForm,
        uriBuilder:UriComponentsBuilder
    ):ResponseEntity<TopicoView> {
        val topicoView = topicoService.cadastrar(form)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    fun editar(@RequestBody @Valid topicoForm: AtualizacaoTopicoForm):ResponseEntity<TopicoView>{
        val topicoView = topicoService.atualizar(topicoForm)
        return ResponseEntity.ok().body(topicoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun excluir(@PathVariable id:Long){
        topicoService.excluir(id)
    }
}