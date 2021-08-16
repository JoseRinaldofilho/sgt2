package br.com.basis.sgt3.web.rest;

import br.com.basis.sgt3.service.ResponsavelService;
import br.com.basis.sgt3.service.dto.ResponsavelDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/responsaveis")
public class ResponsavelResource {

    private final ResponsavelService responsavelService;

    public ResponsavelResource(ResponsavelService responsavelService) {
        this.responsavelService = responsavelService;
    }

    @GetMapping
    public ResponseEntity<List<ResponsavelDTO>> obterTodos(@RequestParam(value = "nome", required = false) String nome) {
        return new ResponseEntity<>(responsavelService.obterTodos(nome), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponsavelDTO> criarTarefa(@RequestBody ResponsavelDTO tarefa) {
        return ResponseEntity.ok(responsavelService.salvar(tarefa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelDTO> obterPorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(responsavelService.obterPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable("id") Long id) {
        responsavelService.deletarPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
