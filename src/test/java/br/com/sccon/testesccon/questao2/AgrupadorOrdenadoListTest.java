package br.com.sccon.testesccon.questao2;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgrupadorOrdenadoListTest {

    @Test
    public void validaNameUpperCaseSemAcento() {
        List<String> nomes = Lists.list("João");
        AgrupadorOrdenadoList l1 = new AgrupadorOrdenadoList(nomes);

        System.out.println(l1);

        assertEquals("{\"JOAO\" = 1}", l1.toString());
    }

    @Test
    public void validaOrdemAlfabetica() {
        AgrupadorOrdenadoList l1 = new AgrupadorOrdenadoList();
        List<String> nomes = Lists.list("Zélia", "João", "Maria");
        l1.addItens(nomes);

        System.out.println(l1);

        assertEquals("{\"JOAO\" = 1, \"MARIA\" = 1, \"ZELIA\" = 1}", l1.toString());
    }

    @Test
    public void validaContadorRepeticao() {
        AgrupadorOrdenadoList l1 = new AgrupadorOrdenadoList();

        l1.addItem("Zélia");
        l1.addItem("João");
        l1.addItem("João");
        l1.addItem("João");
        l1.addItem("Maria");
        l1.addItem("João");
        l1.addItem("Maria");

        System.out.println(l1);

        assertEquals("{\"JOAO\" = 4, \"MARIA\" = 2, \"ZELIA\" = 1}", l1.toString());
    }


}
