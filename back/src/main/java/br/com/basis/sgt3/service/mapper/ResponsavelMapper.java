package br.com.basis.sgt3.service.mapper;

import br.com.basis.sgt3.domain.Responsavel;
import br.com.basis.sgt3.service.dto.ResponsavelDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponsavelMapper extends EntityMapper<ResponsavelDTO, Responsavel> {

}
