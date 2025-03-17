package marceloviana1991.cardapiodigital.controller;

import marceloviana1991.cardapiodigital.model.Grupo;
import marceloviana1991.cardapiodigital.model.Produto;
import marceloviana1991.cardapiodigital.repository.GrupoReposirory;
import marceloviana1991.cardapiodigital.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private GrupoReposirory grupoReposirory;

    @GetMapping("/{grupoId}")
    public List<Produto> listar(@PathVariable Long grupoId) {
        Grupo grupo = grupoReposirory.getReferenceById(grupoId);
        return produtoRepository.findAllByGrupo(grupo);
    }
}
