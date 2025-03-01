package br.com.mumec.msoficinas.api.web.controllers;

import br.com.mumec.msoficinas.api.services.AutenticacaoService;
import br.com.mumec.msoficinas.api.web.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/auth")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("/autenticar")
    public ResponseEntity<?> autenticar(@RequestBody LoginRequest request) throws Exception {
        var response = autenticacaoService.autenticar(request);
        return ResponseEntity.ok(response);
    }
}
