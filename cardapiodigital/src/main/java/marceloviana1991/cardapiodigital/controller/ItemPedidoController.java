package marceloviana1991.cardapiodigital.controller;

import marceloviana1991.cardapiodigital.model.ItemPedido;
import marceloviana1991.cardapiodigital.model.Produto;
import marceloviana1991.cardapiodigital.repository.ItemPedidoRepository;
import marceloviana1991.cardapiodigital.repository.ProdutoRepository;
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

    @PostMapping
    public void registrar(@RequestBody List<ItemPedidoDto> listItemPedidoDto) {
        for(ItemPedidoDto itemPedidoDto: listItemPedidoDto) {
            Produto produto = produtoRepository.getReferenceById(itemPedidoDto.produtoId());
            itemPedidoRepository.save(new ItemPedido(itemPedidoDto.quantidade(), produto));
        }
    }
}

record ItemPedidoDto(int quantidade, Long produtoId) {

}

