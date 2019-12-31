package br.com.megasena.tester.model;

import java.util.ArrayList;
import java.util.List;

public class ResultadoJogoWeb {

    private List<Integer> numerosSorteados;

    public ResultadoJogoWeb() {
        numerosSorteados = new ArrayList<>();
    }

    public void adicionarDezena(Integer dezena) {
        numerosSorteados.add(dezena);
    }

    public List<Integer> getNumerosSorteados() {
        return numerosSorteados;
    }

}
