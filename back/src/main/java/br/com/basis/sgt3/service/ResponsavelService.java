package br.com.basis.sgt3.service;

import br.com.basis.sgt3.domain.Responsavel;
import br.com.basis.sgt3.repository.ResponsavelRepository;
import br.com.basis.sgt3.service.dto.ResponsavelDTO;
import br.com.basis.sgt3.service.error.TarefaNaoEncontradaException;
import br.com.basis.sgt3.service.mapper.ResponsavelMapper;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResponsavelService {

    private final ResponsavelRepository responsavelRepository;
    private final ResponsavelMapper responsavelMapper;

    public ResponsavelService(ResponsavelRepository responsavelRepository, ResponsavelMapper responsavelMapper) {
        this.responsavelRepository = responsavelRepository;
        this.responsavelMapper = responsavelMapper;
    }

    public List<ResponsavelDTO>obterTodos(String nome) {
        if (nome != null && !nome.isEmpty()) {
            return responsavelMapper.toDto(responsavelRepository.encontarTodosPorNome(nome));
        }
        return responsavelMapper.toDto(responsavelRepository.findAll());
    }

    public ResponsavelDTO obterPorId(Long id) {
        Responsavel responsavel = responsavelRepository.findById(id).orElseThrow(TarefaNaoEncontradaException::new);
        return responsavelMapper.toDto(responsavel);
    }

    public ResponsavelDTO salvar(ResponsavelDTO tarefaDTO) {
        Responsavel responsavel = responsavelMapper.toEntity(tarefaDTO);
        Responsavel responsavelSalvo = responsavelRepository.save(responsavel);
        return responsavelMapper.toDto(responsavelSalvo);
    }

    public void deletarPorId(Long id) {
        responsavelRepository.deleteById(id);
    }

}
