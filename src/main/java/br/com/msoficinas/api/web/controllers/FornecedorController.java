package br.com.msoficinas.api.web.controllers;

import br.com.msoficinas.api.services.FornecedorService;
import br.com.msoficinas.api.web.request.FornecedorFilterRequest;
import br.com.msoficinas.api.web.request.FornecedorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("v1/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<?> addFornecedorDoEstabelecimento(@RequestBody FornecedorRequest request) throws Exception {
        var fornecedor = fornecedorService.salvarFornecedorDoEstabelecimento(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(fornecedor.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{idEstabelecimento}")
    public ResponseEntity<?> carregarFornecedoresDoEstabelecimento(@PathVariable(name = "idEstabelecimento") Long idEstabelecimento) {
        var fornecedores = fornecedorService.carregarFornecedoresPeloEstabelecimento(idEstabelecimento);
        return ResponseEntity.ok(fornecedores);
    }

    @PreAuthorize("hasRole('PROP')")
    @DeleteMapping("/remove")
    public ResponseEntity<?> removerFornecedor(@RequestBody FornecedorFilterRequest request) throws Exception {
        System.out.println("Fornecedor "+request.idFornecedor());
        System.out.println("Estabelecimento "+request.idEstabelecimento());
//        fornecedorService.excluirFornecedorDoEstabelecimento(idEstabelecimento, idFornecedor);
        return ResponseEntity.noContent().build();
    }
}
