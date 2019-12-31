package br.com.megasena.tester;

import java.util.List;

public class Jogo {

    private List<Integer> numeros;
    private boolean isCota = false;

    public Jogo(List<Integer> numeros) {
        this.numeros = numeros;
    }

    public Jogo(List<Integer> numeros, boolean isCota) {
        this(numeros);
        this.isCota = isCota;
    }

    public List<Integer> getNumeros() {
        return numeros;
    }

    public boolean isCota() {
        return isCota;
    }

}
