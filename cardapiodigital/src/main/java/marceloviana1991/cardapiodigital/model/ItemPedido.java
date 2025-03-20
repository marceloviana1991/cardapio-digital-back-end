package marceloviana1991.cardapiodigital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "itens_pedido")
@Entity(name = "ItemPedido")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    private Usuario usuario;

    public ItemPedido(int quantidade, Produto produto, Usuario usuario) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.usuario = usuario;
    }
}
