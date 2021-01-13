package br.com.sccon.testesccon.questao1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComplexNumberTest {

    @Test
    public void validaNovoNumeroComplexoComValorZero() {
        ComplexNumber n1 = new ComplexNumber();

        System.out.println(n1);

        assertEquals(0D, n1.getX());
        assertEquals(0D, n1.getY());
    }

    @Test
    public void validaPadraoToString() {
        ComplexNumber n1 = new ComplexNumber();
        ComplexNumber n2 = new ComplexNumber(1D, 6D);
        ComplexNumber n3 = new ComplexNumber(-1D, 6D);
        ComplexNumber n4 = new ComplexNumber(1D, -6D);
        ComplexNumber n5 = new ComplexNumber(-1D, -6D);

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);

        assertEquals("0.0+0.0i", n1.toString());
        assertEquals("1.0+6.0i", n2.toString());
        assertEquals("-1.0+6.0i", n3.toString());
        assertEquals("1.0-6.0i", n4.toString());
        assertEquals("-1.0-6.0i", n5.toString());
    }

    @Test
    public void validaFuncaoAdicao() {
        ComplexNumber n1 = new ComplexNumber(-2D, -1D);
        ComplexNumber n2 = new ComplexNumber(1D, 6D);

        System.out.println(n1 + " + " + n2 + " = ");

        n1.sumComplexNumber(n2);

        System.out.println(n1);

        assertTrue(n1.equals(new ComplexNumber(-1D, 5D)));
        assertTrue(n2.equals(new ComplexNumber(1D, 6D)));
    }

    @Test
    public void validaFuncaoEstaticaAdicao() {
        ComplexNumber n1 = new ComplexNumber(-2D, -1D);
        ComplexNumber n2 = new ComplexNumber(1D, 6D);

        ComplexNumber n3 = ComplexNumber.sumComplexNumber(n1, n2);

        System.out.println(n1 + " + " + n2 + " = ");
        System.out.println(n3);

        assertTrue(n3.equals(new ComplexNumber(-1D, 5D)));
        assertTrue(n1.equals(new ComplexNumber(-2D, -1D)));
        assertTrue(n2.equals(new ComplexNumber(1D, 6D)));
    }

}
