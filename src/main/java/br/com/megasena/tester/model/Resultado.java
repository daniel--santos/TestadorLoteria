package br.com.megasena.tester.model;

public class Resultado {
    private String nomeBolao;
    private Long contagemAcertos;
    private Jogo jogo;

    public Resultado(String nome, long contagemAcertos, Jogo jogo) {
        this.nomeBolao = nome;
        this.contagemAcertos = contagemAcertos;
        this.jogo = jogo;
    }

    public String getNomeBolao() {
        return nomeBolao;
    }

    public Long getContagemAcertos() {
        return contagemAcertos;
    }

    public Jogo getJogo() {
        return jogo;
    }

}
