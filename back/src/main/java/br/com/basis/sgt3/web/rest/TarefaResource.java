package br.com.basis.sgt3.web.rest;

import br.com.basis.sgt3.service.TarefaService;
import br.com.basis.sgt3.service.dto.TarefaDTO;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/tarefas")
public class TarefaResource {

    private final TarefaService tarefaService;

    public TarefaResource(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>>obterTodos(@RequestParam(value = "titulo", required = false) String titulo) {
        return new ResponseEntity<>(tarefaService.obterTodos(titulo), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO tarefa) {
        return ResponseEntity.ok(tarefaService.salvar(tarefa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> obterPorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(tarefaService.obterPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable("id") Long id) {
        tarefaService.deletarPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}