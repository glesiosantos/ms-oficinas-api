package br.com.mumec.msoficinas.api.web.mappers;

import br.com.mumec.msoficinas.api.entidades.Fornecedor;
import br.com.mumec.msoficinas.api.web.request.FornecedorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FornecedorMapper {

    @Mapping(target = "id", source = "idFornecedor")
    @Mapping(target = "nomeFornecedor", source = "nomeFornecedor")
    @Mapping(target = "estabelecimento.id", source = "idEstabelecimento")
    @Mapping(target = "contatos", source = "contatos")
    Fornecedor converterRequestParaModelo(FornecedorRequest request);
}
