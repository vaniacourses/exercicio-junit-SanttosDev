package carrinho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

class CarrinhoTestGPT {

    private Carrinho carrinho;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
        produto1 = new Produto("Arroz", 10.0);
        produto2 = new Produto("Feijão", 20.0);
    }

    @Test
    void carrinhoInicialmenteVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    void adicionarItemAumentaQuantidade() {
        carrinho.addItem(produto1);
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    void adicionarItensSomaValorTotalCorretamente() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        assertEquals(30.0, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    void removerItemExistenteDiminuiQuantidade() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.removeItem(produto1);

        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(20.0, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    void removerItemInexistenteLancaExcecao() {
        assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(produto1));
    }

    @Test
    void esvaziarCarrinhoZeraQuantidadeEValor() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    void podeAdicionarMesmoProdutoVariasVezes() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto1);

        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(20.0, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    void igualdadeDeProdutosBaseadaNoNome() throws ProdutoNaoEncontradoException {
        Produto produtoDuplicado = new Produto("Arroz", 15.0); // mesmo nome que produto1

        carrinho.addItem(produto1);
        carrinho.removeItem(produtoDuplicado); // deve remover porque equals só olha para nome

        assertEquals(0, carrinho.getQtdeItems());
    }
}