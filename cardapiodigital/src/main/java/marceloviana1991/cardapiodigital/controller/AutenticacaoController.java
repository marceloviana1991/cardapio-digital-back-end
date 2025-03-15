package marceloviana1991.cardapiodigital.controller;

import marceloviana1991.cardapiodigital.dto.autenticacao.UsuarioAutenticacaoDto;
import marceloviana1991.cardapiodigital.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody UsuarioAutenticacaoDto usuarioAutenticacaoDto) {
        var token = new UsernamePasswordAuthenticationToken(
                usuarioAutenticacaoDto.login(), usuarioAutenticacaoDto.senha()
                );
        var authentication = manager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}

