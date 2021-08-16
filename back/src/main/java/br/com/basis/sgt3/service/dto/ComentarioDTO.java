package br.com.basis.sgt3.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class ComentarioDTO {

    private Long id;
    private String descricao;
    private LocalDate dataReferencia;
}