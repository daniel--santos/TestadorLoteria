package br.com.megasena.tester;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/resultado")
public class ResultadosResource {

    @RequestMapping(value = "/{numeros}", method = RequestMethod.GET)
    @ResponseBody
    public String verificarResultado(@PathVariable("numeros") String numeros) {
        List<Integer> numerosTeste = Stream.of(numeros.split(",")).map(Integer::parseInt).collect(Collectors.toList());

        List<List<Resultado>> resultadosBoloes = new ArrayList<>();

        for(Bolao b : BoloesCache.getBolaos()) {
            List<Resultado> resultados = ComparadorJogos.compararJogos(numerosTeste, b);
            if(!resultados.isEmpty()) {
                resultadosBoloes.add(resultados);
            }
        }

        String saida = montarSaida(resultadosBoloes);

//        return ResponseEntity.status(HttpStatus.OK).body(BoloesCache.getBolaos());
        return saida;
    }

    private String montarSaida(List<List<Resultado>> resultadosBoloes) {
        StringBuilder sb = new StringBuilder();

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

}
