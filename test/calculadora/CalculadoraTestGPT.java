package calculadora;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testes unitários para a classe Calculadora.
 * Usando JUnit 5 e compatível com Java 8.
 */
public class CalculadoraTestGPT {

    private Calculadora calc;

    @BeforeEach
    void setUp() {
        calc = new Calculadora();
    }

    // ---- Testes de Soma ----
    @Test
    void deveSomarNumerosPositivos() {
        assertEquals(7, calc.soma(3, 4));
    }

    @Test
    void deveSomarComZero() {
        assertEquals(5, calc.soma(5, 0));
    }

    @Test
    void deveSomarNumerosNegativos() {
        assertEquals(-8, calc.soma(-3, -5));
    }

    // ---- Testes de Subtração ----
    @Test
    void deveSubtrairNumerosPositivos() {
        assertEquals(2, calc.subtracao(5, 3));
    }

    @Test
    void deveSubtrairComZero() {
        assertEquals(5, calc.subtracao(5, 0));
    }

    @Test
    void deveSubtrairNumerosNegativos() {
        assertEquals(-1, calc.subtracao(-3, -2));
    }

    // ---- Testes de Multiplicação ----
    @Test
    void deveMultiplicarNumerosPositivos() {
        assertEquals(20, calc.multiplicacao(4, 5));
    }

    @Test
    void deveMultiplicarPorZero() {
        assertEquals(0, calc.multiplicacao(7, 0));
    }

    @Test
    void deveMultiplicarNumerosNegativos() {
        assertEquals(-12, calc.multiplicacao(-3, 4));
    }

    @Test
    void deveMultiplicarDoisNegativos() {
        assertEquals(15, calc.multiplicacao(-3, -5));
    }

    // ---- Testes de Divisão ----
    @Test
    void deveDividirNumerosPositivos() {
        assertEquals(2, calc.divisao(10, 5));
    }

    @Test
    void deveDividirComResultadoNegativo() {
        assertEquals(-4, calc.divisao(-8, 2));
    }

    @Test
    void deveDividirDoisNegativos() {
        assertEquals(3, calc.divisao(-9, -3));
    }

    @Test
    void deveLancarExcecaoAoDividirPorZero() {
        assertThrows(ArithmeticException.class, () -> calc.divisao(5, 0));
    }

    // ---- Testes de Somatória ----
    @Test
    void deveCalcularSomatoriaDeZero() {
        assertEquals(0, calc.somatoria(0));
    }

    @Test
    void deveCalcularSomatoriaDeNumeroPositivo() {
        assertEquals(15, calc.somatoria(5)); // 0+1+2+3+4+5 = 15
    }

    @Test
    void deveCalcularSomatoriaDeNumeroNegativo() {
        assertEquals(0, calc.somatoria(-3));
    }

    // ---- Testes de EhPositivo ----
    @Test
    void deveRetornarTrueSeNumeroPositivo() {
        assertTrue(calc.ehPositivo(10));
    }

    @Test
    void deveRetornarTrueSeNumeroZero() {
        assertTrue(calc.ehPositivo(0));
    }

    @Test
    void deveRetornarFalseSeNumeroNegativo() {
        assertFalse(calc.ehPositivo(-1));
    }

    // ---- Testes de Comparação ----
    @Test
    void deveRetornarZeroSeNumerosIguais() {
        assertEquals(0, calc.compara(5, 5));
    }

    @Test
    void deveRetornarUmSePrimeiroMaior() {
        assertEquals(1, calc.compara(7, 3));
    }

    @Test
    void deveRetornarMenosUmSePrimeiroMenor() {
        assertEquals(-1, calc.compara(2, 10));
    }
}
