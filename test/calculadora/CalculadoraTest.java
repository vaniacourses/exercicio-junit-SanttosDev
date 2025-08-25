package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CalculadoraTest {
    private Calculadora calc;
    private static Integer i;
    @BeforeAll
    static public void setup(){
        i = 0;
        System.out.println("Starting");
    }
    @BeforeEach
    public void start(){
        calc = new Calculadora();
        i++;
        System.out.println("Passando pelo Teste: " + i.toString());
    }

    @AfterEach
    public void finish(){
        System.out.println("Teste " + i.toString() + " terminado");
    }

    @AfterAll
    static public void end(){
        System.out.println("Finalizados testes.");
    }

    @Test
    @DisplayName("soma2numeros")
    public void soma2numeros(){
        int soma = calc.soma(1,1);
        Assertions.assertEquals(2,soma);
    }

    @Test
    @DisplayName("subtracao2numeros")
    public void sub2numeros(){
        int sub = calc.subtracao(5,3);
        Assertions.assertEquals(2,sub);
    }

    @Test
    @DisplayName("divisao2numeros")
    public void div2numeros(){
        int div = calc.divisao(10,2);
        Assertions.assertEquals(5,div);
    }

    @Test
    @DisplayName("multiplicao2numeros")
        public void multp2numeros(){
            int multp = calc.multiplicacao(10,2);
            Assertions.assertEquals(20, multp);
        }
}