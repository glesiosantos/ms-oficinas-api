package br.com.mumec.msoficinas.api.web.mappers;

import br.com.mumec.msoficinas.api.entidades.Estabelecimento;
import br.com.mumec.msoficinas.api.web.request.EstabelecimentoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EstabelecimentoMapper {

    @Mapping(target = "cpfOuCnpj", source = "cpfOuCnpj")
    @Mapping(target = "razaoSocial", source = "razaoSocial")
    @Mapping(target = "nomeFantasia", source = "nomeFantasia")
    @Mapping(target = "plano", source = "plano")
    @Mapping(target = "ativo", source = "ativo")
    @Mapping(target = "dataVencimento", source = "vencimento")
    @Mapping(target = "endereco.cep", source = "cep")
    @Mapping(target = "endereco.logradouro", source = "logradouro")
    @Mapping(target = "endereco.bairro", source = "bairro")
    @Mapping(target = "endereco.cidade", source = "cidade")
    @Mapping(target = "endereco.estado", source = "estado")
    @Mapping(target = "endereco.latitude", source = "latitude")
    @Mapping(target = "endereco.longitude", source = "longitude")
    Estabelecimento converterRequestParaModel(EstabelecimentoRequest request);
}
