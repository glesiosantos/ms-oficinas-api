package br.com.mumec.msoficinas.api.config;

import br.com.mumec.msoficinas.api.entidades.Endereco;
import br.com.mumec.msoficinas.api.entidades.Estabelecimento;
import br.com.mumec.msoficinas.api.entidades.Usuario;
import br.com.mumec.msoficinas.api.enuns.Estado;
import br.com.mumec.msoficinas.api.enuns.Perfil;
import br.com.mumec.msoficinas.api.enuns.Plano;
import br.com.mumec.msoficinas.api.repositories.EstabelecimentoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class ClienteParaTestes implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteParaTestes.class);

    public void inserirClienteTest () {
        LOGGER.info("Preparando estabelecimento para teste .... ");

        Estabelecimento estabelecimento = Estabelecimento.builder()
                .ativo(true)
                .paraTestes(true)
                .cpfOuCnpj("13458785000192")
                .nomeFantasia("Auto Center para Teste")
                .razaoSocial("GLESIO SANTOS da SILVA AUTO TESTE")
                .contatos(Set.of("86998490423"))
                .endereco(Endereco.builder().cep("64010530").logradouro("Rua Des. Caio Oliveira, 8115").bairro("Mocambinho").cidade("Teresina").estado(Estado.PI).build())
                .dataVencimento(10)
                .plano(Plano.BASIC)
                .build();

        Usuario usuario = Usuario.builder()
                .estabelecimentos(Set.of(estabelecimento))
                .cpf("96548517334")
                .nomeCompleto("Glêsio Santos da Silva")
                .senha(passwordEncoder.encode("965485"))
                .ativo(true)
                .perfil(Perfil.PROP)
                .avatar("default.png")
                .build();
        estabelecimento.setUsuarios(Set.of(usuario));

        LOGGER.info("Verificando se já existe estabelecimento de teste .... ");
        if (estabelecimentoRepository.findByCpfOuCnpj(estabelecimento.getCpfOuCnpj()).isPresent()) {
            LOGGER.info("Estabelecimento já existe .... ");
        } else {
            LOGGER.info("Registrando estabelecimento de teste .... ");
            estabelecimentoRepository.save(estabelecimento);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        inserirClienteTest();
    }
}
