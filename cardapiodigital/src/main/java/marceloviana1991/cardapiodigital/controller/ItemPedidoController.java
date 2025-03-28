package marceloviana1991.cardapiodigital.controller;

import jakarta.servlet.http.HttpServletRequest;
import marceloviana1991.cardapiodigital.model.ItemPedido;
import marceloviana1991.cardapiodigital.model.Produto;
import marceloviana1991.cardapiodigital.model.Usuario;
import marceloviana1991.cardapiodigital.repository.ItemPedidoRepository;
import marceloviana1991.cardapiodigital.repository.ProdutoRepository;
import marceloviana1991.cardapiodigital.repository.UsuarioRepository;
import marceloviana1991.cardapiodigital.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void registrar(@RequestBody List<ItemPedidoDto> listItemPedidoDto, HttpServletRequest request) {
        var subject = tokenService.getSubject(
                request.getHeader("Authorization")
                        .replace("Bearer ", "")
        );
        Usuario usuario = (Usuario) usuarioRepository.findByLogin(subject);
        for(ItemPedidoDto itemPedidoDto: listItemPedidoDto) {
            Produto produto = produtoRepository.getReferenceById(itemPedidoDto.produtoId());
            itemPedidoRepository.save(new ItemPedido(itemPedidoDto.quantidade(), produto, usuario));
        }
    }
}

record ItemPedidoDto(int quantidade, Long produtoId) {

}



