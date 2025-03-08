package br.com.msoficinas.api.messageria;

import br.com.msoficinas.api.services.EstabelecimentoService;
import br.com.msoficinas.api.web.request.EstabelecimentoRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstabelecimentoConsumidorRabbitMQ {

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @RabbitListener(queues = "${rabbitmq.queue.criar-oficina}")
    public void criarEstabelecimentoListener(EstabelecimentoRequest request) throws Exception {
        System.out.printf("**** recebendo dados do estabelecimento %s", request.razaoSocial());
        var estabelecimento = estabelecimentoService.cadastrarEstabelecimento(request);
        System.out.printf("*** estabelecimento '%s' registrado com sucesso!",estabelecimento.getRazaoSocial());
    }

}
