package marceloviana1991.cardapiodigital.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteDeAutenticacao {

    @GetMapping
    public void testarAutenticacao() {

    }
}
