import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Conta_corrente;

public class Teste {
    private Conta_corrente contaMaria;
    private Conta_corrente contaJose;

    @BeforeEach
    public void setUp() {
        contaMaria = new Conta_corrente(200, "Maria");
        contaJose = new Conta_corrente(100, "José");
    }

    @Test
    public void testContasCriadas() {
        assertEquals(200, contaMaria.getBalanço(), "O saldo da Maria deve ser 200.");
        assertEquals(100, contaJose.getBalanço(), "O saldo do José deve ser 100.");
        assertNotNull(contaMaria, "A conta da Maria deve ser criada.");
        assertNotNull(contaJose, "A conta do José deve ser criada.");
    }

    @Test
    public void testSaldoInicialDiferente() {
        assertEquals(200, contaMaria.getBalanço(), "O saldo da Maria deve ser 200.");
        assertEquals(100, contaJose.getBalanço(), "O saldo do José deve ser 100.");
        assertEquals(contaMaria.getBalanço(), contaJose.getBalanço() + 100, "O saldo da Maria deve ser 100 a mais que o saldo do José.");
    }

    @Test
    public void testSaqueAcimaDoDisponível() {
        boolean resultado = contaMaria.saque(300);
        assertFalse(resultado, "Sacar um valor acima do disponível deve retornar false.");
        assertEquals(200, contaMaria.getBalanço(), "O saldo da Maria deve permanecer o mesmo após tentativa de saque acima do disponível.");
    }

    @Test
    public void testSaqueDentroDoDisponível() {
        boolean resultado = contaMaria.saque(100);
        assertTrue(resultado, "Sacar um valor dentro do disponível deve retornar true.");
        assertEquals(100, contaMaria.getBalanço(), "Após o saque, o saldo da Maria deve ser 100.");
    }

    @Test
    public void testDepositoJose() {
        contaMaria.saque(100);
        contaJose.deposito(50);
        assertEquals(contaMaria.getBalanço() + 50, contaJose.getBalanço(), "Após o depósito, o saldo do José deve ser igual ao saldo da Maria mais R$50.");
    }
}





// package com.example ;
// public class Calculadora {
//  public Integer soma(Integer a, Integer b){
//  return a + b;
//  }
// }


// import org.junit.jupiter.api.Test;
// import com.example.Calculadora;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// public class CalculadoraTest {
//  @Test
//  public void testSoma() {
//  Calculadora calc = new Calculadora();
//  int resultado = calc.soma(2, 3);
//  assertEquals(5, resultado);
//  }
// }