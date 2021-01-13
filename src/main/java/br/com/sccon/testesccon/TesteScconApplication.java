package br.com.sccon.testesccon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesteScconApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesteScconApplication.class, args);

//        testarNumerosComplexos();
    }

    /*static void testarNumerosComplexos() {
        ComplexNumber n1 = new ComplexNumber();
        ComplexNumber n2 = new ComplexNumber(5D, -2D);
        System.out.println("n1: " + n1);
        System.out.println("n2: " + n2);

        n1.sumComplexNumber(n2);
        System.out.println("n1 + n2: " + n1);

    }*/

}
