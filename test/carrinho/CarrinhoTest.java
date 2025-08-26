package carrinho;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;


@DisplayName("Classe para teste da Carrinho")
public class CarrinhoTest {

    private Carrinho carr;
    private Produto p1;
    private Produto p2;
    private static Integer i;
	
    @BeforeAll
    static public void setup() {
        i = 0;
        System.out.println("Inicando Teste Carrinho: \n");
    }

    @BeforeEach
	public void start() {
		carr = new Carrinho();
        p1 = new Produto("Perfume", 100);
        p2 = new Produto("Livro", 20);
        i++;
        System.out.println("Passando pelo Teste: " + i.toString());

	}

    @AfterEach
    public void finish(){
        System.out.println("Teste " + i.toString() + " terminado");
    }

    @AfterAll
    static public void end(){
        System.out.println("Finalizados teste.");
    }

    @Test
    @DisplayName("Add item")
    public void addItem() {
        carr.addItem(p1);
        Assertions.assertEquals(1, carr.getQtdeItems());
    }

    @Test
    @DisplayName("Remover item")
    public void removerItem() {
        carr.addItem(p1);
        carr.addItem(p2);
        try {
            carr.removeItem(p1);
        } catch (ProdutoNaoEncontradoException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(20, carr.getValorTotal());
    }

    @Test
    @DisplayName("Valor Total test")
    public void valorTotal() {
        carr.addItem(p1);
        carr.addItem(p2);
        Assertions.assertEquals(120, carr.getValorTotal());
    }


    
}
