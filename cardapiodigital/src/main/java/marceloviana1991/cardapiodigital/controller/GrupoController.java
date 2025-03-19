package marceloviana1991.cardapiodigital.controller;

import marceloviana1991.cardapiodigital.model.Grupo;
import marceloviana1991.cardapiodigital.repository.GrupoReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grupo")
public class GrupoController {

    @Autowired
    private GrupoReposirory reposirory;

    @GetMapping
    public List<GrupoDto> listar() {
        return reposirory.findAll().stream().map(GrupoDto::new).toList();
    }

    @GetMapping("/{id}")
    public GrupoDto recuperar(@PathVariable Long id) {
        return new GrupoDto(reposirory.getReferenceById(id));
    }
}

record GrupoDto(
        Long id,
        String nome,
        String imagem
) {
    GrupoDto(Grupo grupo) {
        this(
                grupo.getId(),
                grupo.getNome(),
                grupo.getImagem()
        );
    }

}
