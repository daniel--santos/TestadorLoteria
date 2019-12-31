package br.com.megasena.tester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoloesCache {

    private static List<Bolao> bolaos = new ArrayList<>();

    static {
        Bolao bolaoMartinez = new Bolao("Martinez");
        //cota 5/10
        bolaoMartinez.adionarJogo(new Jogo(Arrays.asList(16,21,24,41,47,49,60), true));//7
        bolaoMartinez.adionarJogo(new Jogo(Arrays.asList(2,8,10,28,41,44,52), true));//7
        bolaoMartinez.adionarJogo(new Jogo(Arrays.asList(9,16,24,33,39,53,60), true));//7
        bolaoMartinez.adionarJogo(new Jogo(Arrays.asList(4,8,15,16,28,30,32), true));//7
        bolaoMartinez.adionarJogo(new Jogo(Arrays.asList(16,19,24,25,42,59,60), true));//7
        //cota 17/25
        bolaoMartinez.adionarJogo(new Jogo(Arrays.asList(3,6,11,21,34,38,42,45), true));//9
        bolaoMartinez.adionarJogo(new Jogo(Arrays.asList(8,12,18,26,30,37,41,46,51), true));//9
        bolaoMartinez.adionarJogo(new Jogo(Arrays.asList(9,14,17,24,29,35,40,44), true));//9
        bolaoMartinez.adionarJogo(new Jogo(Arrays.asList(2,7,19,22,33,47,54,59), true));//9
        bolaoMartinez.adionarJogo(new Jogo(Arrays.asList(5,10,13,16,25,28,32,43,58), true));//9
        //cota 24/25
        bolaoMartinez.adionarJogo(new Jogo(Arrays.asList(2,10,15,17,24,28,32,36,39,41,53,59)));//12
        //Jogo simples
        bolaoMartinez.adionarJogo(new Jogo(Arrays.asList(14,17,27,32,38,47)));//6
        bolaoMartinez.adionarJogo(new Jogo(Arrays.asList(6,3,12,13,36,50)));//6
        bolaoMartinez.adionarJogo(new Jogo(Arrays.asList(5,9,10,21,42,54)));//6

        Bolao bolaoTrabalho = new Bolao("Trabalho");
        bolaoTrabalho.adionarJogo(new Jogo(Arrays.asList(2,19,25,26,30,37)));//6
        bolaoTrabalho.adionarJogo(new Jogo(Arrays.asList(3,7,18,22,30,50)));//6
        bolaoTrabalho.adionarJogo(new Jogo(Arrays.asList(25,41,50,53,59,60)));//6
        bolaoTrabalho.adionarJogo(new Jogo(Arrays.asList(17,19,22,28,44,48)));//6
        bolaoTrabalho.adionarJogo(new Jogo(Arrays.asList(25,29,34,49,53,58)));//6
        bolaoTrabalho.adionarJogo(new Jogo(Arrays.asList(22,23,26,29,56,60)));//6
        bolaoTrabalho.adionarJogo(new Jogo(Arrays.asList(8,13,19,31,37,43,55)));//7
        bolaoTrabalho.adionarJogo(new Jogo(Arrays.asList(2,12,20,26,30,40,47)));//7
        bolaoTrabalho.adionarJogo(new Jogo(Arrays.asList(8,15,18,24,26,41,42,49,53)));//9

        Bolao bolaoTiago = new Bolao("Tiago");
        bolaoTiago.adionarJogo(new Jogo(Arrays.asList(2,5,7,16,17,27,28,50)));//8

        //Adicionando os boloes
        bolaos.add(bolaoMartinez);
        bolaos.add(bolaoTrabalho);
        bolaos.add(bolaoTiago);
    }

    public static List<Bolao> getBolaos() {
        return bolaos;
    }
}
