package calculadora;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
		
	@Test
    @DisplayName("soma2numeros")
	public void soma2numeros() {
		int soma = calc.soma(2, 2);		
		Assertions.assertEquals(4, soma);		
	}
	
	@Test
    @DisplayName("divisao2numeros")
	public void divisao2numeros() {
		int div = calc.divisao(10, 2);
		assertTrue(div == 5);
	}
	
	@Test
    @DisplayName("divisaoporzero")
	public void divisaoPorZero() {
        try {
            calc.divisao(10, 0);
            Assertions.fail("Exceção não lançada");
        } catch (ArithmeticException e) {
            Assertions.assertEquals("/ by zero", e.getMessage());
        }
    }
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

    @Test
    @DisplayName("Multiplicação de 2 números")
    public void multiplica2numeros() {
        int mult = calc.multiplicacao(10, 2);
        Assertions.assertEquals(20, mult);
    }

}