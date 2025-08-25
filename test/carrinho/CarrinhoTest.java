package carrinho;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Classe para teste do carrinho")

public class CarrinhoTest{
    private Carrinho car;
    private Produto p1;
    private Produto p2;
    private static Integer i;
    @BeforeAll
    static public void setup(){
        i = 0;
        System.out.println("Starting Tests Carrinho: \n");
    }
    @BeforeEach
    public void start(){
        car = new Carrinho();
        p1 = new Produto("Camiseta1", 80.00);
        p2 = new Produto("Tenis1", 450.00);
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
    public void testAddItem(){
        car.addItem(p1);
        Assertions.assertEquals(1, car.getQtdeItems());
    }

    @Test
    public void testGetValorTotal(){
        car.addItem(p1);
        car.addItem(p2);
        Assertions.assertEquals(530.00, car.getValorTotal());
    }

    @Test
    public void testRemoveItem(){
        car.addItem(p1);
        car.addItem(p2);
        try {
            car.removeItem(p1);
        } catch (ProdutoNaoEncontradoException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(450.00, car.getValorTotal());
    }

    @Test
    public void testEsvaziaLixeira(){
        car.addItem(p1);
        car.addItem(p2);
        car.esvazia();
        Assertions.assertEquals(0, car.getQtdeItems());
    }


}