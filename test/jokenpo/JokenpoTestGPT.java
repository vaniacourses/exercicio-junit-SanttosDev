package jokenpo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe de testes unitários para a classe Jokenpo.
 * Usando JUnit 5 e compatível com Java 8.
 */
public class JokenpoTestGPT {

    private Jokenpo jokenpo;

    @BeforeEach
    void setUp() {
        jokenpo = new Jokenpo();
    }

    // ---- Testes de Empate ----
    @Test
    void deveRetornarEmpateQuandoAmbosEscolhemPapel() {
        assertEquals(0, jokenpo.jogar(1, 1));
    }

    @Test
    void deveRetornarEmpateQuandoAmbosEscolhemPedra() {
        assertEquals(0, jokenpo.jogar(2, 2));
    }

    @Test
    void deveRetornarEmpateQuandoAmbosEscolhemTesoura() {
        assertEquals(0, jokenpo.jogar(3, 3));
    }

    // ---- Testes de Vitórias do Jogador 1 ----
    @Test
    void deveVencerJogador1QuandoPapelContraPedra() {
        assertEquals(1, jokenpo.jogar(1, 2));
    }

    @Test
    void deveVencerJogador1QuandoPedraContraTesoura() {
        assertEquals(1, jokenpo.jogar(2, 3));
    }

    @Test
    void deveVencerJogador1QuandoTesouraContraPapel() {
        assertEquals(1, jokenpo.jogar(3, 1));
    }

    // ---- Testes de Vitórias do Jogador 2 ----
    @Test
    void deveVencerJogador2QuandoPapelContraTesoura() {
        assertEquals(2, jokenpo.jogar(1, 3));
    }

    @Test
    void deveVencerJogador2QuandoPedraContraPapel() {
        assertEquals(2, jokenpo.jogar(2, 1));
    }

    @Test
    void deveVencerJogador2QuandoTesouraContraPedra() {
        assertEquals(2, jokenpo.jogar(3, 2));
    }

    // ---- Testes de Entradas Inválidas ----
    @Test
    void deveRetornarInvalidoQuandoJogador1ForaDoIntervalo() {
        assertEquals(-1, jokenpo.jogar(0, 2));
        assertEquals(-1, jokenpo.jogar(4, 1));
    }

    @Test
    void deveRetornarInvalidoQuandoJogador2ForaDoIntervalo() {
        assertEquals(-1, jokenpo.jogar(1, 0));
        assertEquals(-1, jokenpo.jogar(2, 5));
    }

    @Test
    void deveRetornarInvalidoQuandoAmbosForaDoIntervalo() {
        assertEquals(-1, jokenpo.jogar(-1, 99));
    }
}
