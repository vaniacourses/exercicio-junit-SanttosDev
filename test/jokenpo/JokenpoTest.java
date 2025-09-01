package jokenpo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da jokenpo")
public class JokenpoTest {
    
    private Jokenpo jokenpo;
    private static Integer i;

    @BeforeAll
    static public void setup() {
        i = 0;
        System.out.println("Inicando Teste Carrinho: \n");
    }

    @BeforeEach
	public void start() {
		jokenpo = new Jokenpo();
        i++;
        System.out.println("Passando pelo Teste: " + i.toString());
	}
    
    @Test
    @DisplayName("Vencendor Jogador 1")
    public void vencedorJogador1() {
        Assertions.assertEquals(1, jokenpo.jogar(1, 2));
        Assertions.assertEquals(1, jokenpo.jogar(2, 3));
        Assertions.assertEquals(1, jokenpo.jogar(3, 1));
    }

    @Test
    @DisplayName("Vencendor Jogador 2")
    public void vencedorJogador2() {
        Assertions.assertEquals(2, jokenpo.jogar(2, 1));
        Assertions.assertEquals(2, jokenpo.jogar(3, 2));
        Assertions.assertEquals(2, jokenpo.jogar(1, 3));
    }
    
    @Test
    @DisplayName("Empate")
    public void empate() {
        Assertions.assertEquals(0, jokenpo.jogar(1, 1));
        Assertions.assertEquals(0, jokenpo.jogar(2, 2));
        Assertions.assertEquals(0, jokenpo.jogar(3, 3));
    } 

}