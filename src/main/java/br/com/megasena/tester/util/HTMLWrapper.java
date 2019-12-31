package br.com.megasena.tester.util;

import br.com.megasena.tester.model.Resultado;

import java.util.List;

public class HTMLWrapper {

    public static String montarSaidaBoloes(List<List<Resultado>> resultadosBoloes) {
        StringBuilder sb = new StringBuilder();

        if(resultadosBoloes.isEmpty()) {
            sb.append("Nos vemos dia 06/01, não foi dessa vez...");
            sb.append("<br><br>");
            sb.append("0 acertos");
        }

        for(List<Resultado> resultados : resultadosBoloes) {
            sb.append("\t Bolão ");
            sb.append(resultados.get(0).getNomeBolao());
            sb.append("<br>");
            sb.append("<br>");

            for(Resultado resultado : resultados) {
                sb.append("\t\tAcertos: ");
                sb.append(resultado.getContagemAcertos());
                sb.append(" - Números: ");
                sb.append(resultado.getJogo().getNumeros());
                sb.append("<br>");
            }

            sb.append("<br>");
        }

        return sb.toString();
    }

    public static String montarSaidaResultadoAindaNaoDivulgado(String numeroConcurso) {
        return "Resultado do concurso " + numeroConcurso + " ainda não divulgado. ";
    }
}
