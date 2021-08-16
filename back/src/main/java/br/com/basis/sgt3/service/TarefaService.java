package br.com.basis.sgt3.service;

import br.com.basis.sgt3.domain.Tarefa;
import br.com.basis.sgt3.repository.TarefaRepository;
import br.com.basis.sgt3.service.dto.TarefaDTO;
import br.com.basis.sgt3.service.error.TarefaNaoEncontradaException;
import br.com.basis.sgt3.service.mapper.TarefaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;

    public TarefaService(TarefaRepository tarefaRepository, TarefaMapper tarefaMapper) {
        this.tarefaRepository = tarefaRepository;
        this.tarefaMapper = tarefaMapper;
    }

    public List<TarefaDTO> obterTodos(String titulo) {
        if (titulo != null && !titulo.isEmpty()) {
            return tarefaMapper.toDto(tarefaRepository.encontarTodosPorTitulo(titulo));
        }
        return tarefaMapper.toDto(tarefaRepository.findAll());
    }

    public TarefaDTO obterPorId(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(TarefaNaoEncontradaException::new);
        return tarefaMapper.toDto(tarefa);
    }

    public TarefaDTO salvar(TarefaDTO tarefaDTO) {
        Tarefa tarefa = tarefaMapper.toEntity(tarefaDTO);
        Tarefa tarefaSalva = tarefaRepository.save(tarefa);
        return tarefaMapper.toDto(tarefaSalva);
    }

    public void deletarPorId(Long id) {
        tarefaRepository.deleteById(id);
    }

}