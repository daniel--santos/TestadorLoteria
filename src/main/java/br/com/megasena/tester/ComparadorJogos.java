package br.com.megasena.tester;

import java.util.ArrayList;
import java.util.List;

public class ComparadorJogos {

    public static List<Resultado> compararJogos(List<Integer> numeros, Bolao bolao) {
        List<Resultado> resultadosBolao = new ArrayList<>();

        for(Jogo j : bolao.getJogos()) {
            long contagemAcertos = j.getNumeros().stream().filter(numeros::contains).count();

            if(contagemAcertos >= 4) {
                resultadosBolao.add(new Resultado(bolao.getNome(), contagemAcertos, j));
            }
        }

        return resultadosBolao;
    }

}
