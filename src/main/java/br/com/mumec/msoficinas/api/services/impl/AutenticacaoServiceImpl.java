package br.com.mumec.msoficinas.api.services.impl;

import br.com.mumec.msoficinas.api.entidades.Usuario;
import br.com.mumec.msoficinas.api.services.AutenticacaoService;
import br.com.mumec.msoficinas.api.services.JwtService;
import br.com.mumec.msoficinas.api.services.UsuarioService;
import br.com.mumec.msoficinas.api.web.request.LoginRequest;
import br.com.mumec.msoficinas.api.web.response.EstabelecimentoLoginResponse;
import br.com.mumec.msoficinas.api.web.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtService jwtService;

    @Override
    public LoginResponse autenticar(LoginRequest request) throws Exception {
        var authenticated = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.cpf().replace(".","").replace("-",""), request.senha()));
        Usuario usuario = usuarioService.buscarUsuarioPeloCpf(authenticated.getName());
        String token = jwtService.gerarToken((UserDetails) authenticated.getPrincipal());
        List<EstabelecimentoLoginResponse> estabelecimentos =  usuario.getEstabelecimentos() //convertendo lista de estabelecimentos
                .stream().map(estabelecimento -> new EstabelecimentoLoginResponse(estabelecimento.getId(), estabelecimento.getNomeFantasia())).toList();
        return new LoginResponse(token, estabelecimentos, usuario.getCpf(), usuario.getNomeCompleto(), usuario.getPerfil().getNome());
    }

    @Override
    public boolean validarToken(String token) {
        return jwtService.validarToken(token.substring(7)).isEmpty();
    }

    @Override
    public void alterarSenha() {}

    @Override
    public void recuperarSenha() {}
}
