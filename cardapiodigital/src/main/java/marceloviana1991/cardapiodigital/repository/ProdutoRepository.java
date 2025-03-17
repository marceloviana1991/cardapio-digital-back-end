package marceloviana1991.cardapiodigital.repository;

import marceloviana1991.cardapiodigital.model.Grupo;
import marceloviana1991.cardapiodigital.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByGrupo(Grupo grupo);
}
