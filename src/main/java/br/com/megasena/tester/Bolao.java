package br.com.megasena.tester;

import java.util.ArrayList;
import java.util.List;

public class Bolao {

    private String nome;
    private List<Jogo> jogos;

    public Bolao(String nome) {
        this.nome = nome;
        jogos = new ArrayList<>();
    }

    public void adionarJogo(Jogo jogo) {
        jogos.add(jogo);
    }

    public String getNome() {
        return nome;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

}
