package br.com.basis.sgt3.service.dto;

import br.com.basis.sgt3.domain.TipoTarefa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private String status;
    private LocalDate dtInicio;
    private LocalDate dtTerminoPrevisto;
    private LocalDate dtTerminoEfetivo;
    private List<ComentarioDTO> comentarios;
}