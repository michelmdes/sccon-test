package br.com.sccon.testesccon.questao1;

import org.springframework.lang.NonNull;

import java.util.Objects;

public class ComplexNumber {

    @NonNull
    private Double x;
    @NonNull
    private Double y; // parte imaginária

    public ComplexNumber() {
        this.x = 0D;
        this.y = 0D;
    }

    public ComplexNumber(@NonNull Double parteReal, @NonNull Double parteImaginaria) {
        this.x = parteReal;
        this.y = parteImaginaria;
    }

    public void sumComplexNumber(ComplexNumber n2) {
        ComplexNumber sum = sumComplexNumber(this, n2);
        this.x = sum.getX();
        this.y = sum.getY();
    }

    public static ComplexNumber sumComplexNumber(ComplexNumber n1, ComplexNumber n2) {
        if (n1 == null || n2 == null)
            throw new IllegalArgumentException("Para realizar a soma, os numeros complexos devem ser diferentes de null.");
        return new ComplexNumber(n1.getX() + n2.getX(), n1.getY() + n2.getY());
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof ComplexNumber)
            return Objects.equals(this.x, ((ComplexNumber) obj).getX()) && Objects.equals(this.y, ((ComplexNumber) obj).getY());
        return false;
    }

    @Override
    public String toString() {
        return getX() + (getY() >= 0 ? "+" : "") + getY() + "i";
    }
}
