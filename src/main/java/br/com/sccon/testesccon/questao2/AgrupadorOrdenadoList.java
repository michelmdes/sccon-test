package br.com.sccon.testesccon.questao2;

import java.text.Normalizer;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AgrupadorOrdenadoList {

    Map<String, Long> mapa;

    public AgrupadorOrdenadoList() {
        this.mapa = new TreeMap<>();
    }

    public AgrupadorOrdenadoList(List<String> nomes) {
        this.mapa = new TreeMap<>();
        addItens(nomes);
    }

    public Map<String, Long> getLista() {
        return this.mapa;
    }

    public void addItem(String nome) {
        String nomePadronizado = removerAcentos(nome).toUpperCase();
        if (this.mapa.containsKey(nomePadronizado))
            this.mapa.put(nomePadronizado, this.mapa.get(nomePadronizado) + 1);
        else
            this.mapa.put(nomePadronizado, 1L);
    }

    public void addItens(List<String> nomes) {
        nomes.forEach(this::addItem);
    }

    private String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    @Override
    public String toString() {
        String toString = getLista().keySet().stream().reduce("", (acc, i) -> acc + "\"" + i + "\"" + " = " + getLista().get(i) + ", ");
        if (toString.endsWith(", "))
            toString = toString.substring(0, toString.length() - 2);
        return "{" + toString + "}";
    }
}
