package br.com.mumec.msoficinas.api.web.controllers;

import br.com.mumec.msoficinas.api.services.FornecedorService;
import br.com.mumec.msoficinas.api.web.request.FornecedorRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<?> cadastrarFornecedor(@RequestBody @Valid FornecedorRequest request) throws Exception {
        var fornecedor = fornecedorService.salvarFornecedor(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(fornecedor.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{idEstabelecimento}")
    public ResponseEntity<?> atualizarFornecedor(@RequestParam(required = true, name = "idEstabelecimento") Long id) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> carregarFornecedores(@RequestParam(required = true, name = "idEstabelecimento") Long idEstabelecimento) {
        return ResponseEntity.ok(fornecedorService.carregarFornecedoresPeloEstabelecimento(idEstabelecimento));
    }
}
