package br.com.megasena.tester.resources;

import br.com.megasena.tester.BasicWebCrawler;
import br.com.megasena.tester.BoloesCache;
import br.com.megasena.tester.ComparadorJogos;
import br.com.megasena.tester.model.Bolao;
import br.com.megasena.tester.model.Resultado;
import br.com.megasena.tester.model.ResultadoJogoWeb;
import br.com.megasena.tester.util.HTMLWrapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/app/resultado")
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

        return HTMLWrapper.montarSaidaBoloes(resultadosBoloes);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String verificarResultado2() {
        String concurso = "2220";
        ResultadoJogoWeb resultadoJogoWeb = new BasicWebCrawler().getInfo("https://confiraloterias.com.br/megasena/", concurso);

        if(resultadoJogoWeb == null) {
            return HTMLWrapper.montarSaidaResultadoAindaNaoDivulgado(concurso);
        }

        List<List<Resultado>> resultadosBoloes = new ArrayList<>();

        for(Bolao b : BoloesCache.getBolaos()) {
            List<Resultado> resultados = ComparadorJogos.compararJogos(resultadoJogoWeb.getNumerosSorteados(), b);
            if(!resultados.isEmpty()) {
                resultadosBoloes.add(resultados);
            }
        }

        return HTMLWrapper.montarSaidaBoloes(resultadosBoloes);
    }

    @RequestMapping(value = "/facaparte", method = RequestMethod.GET)
    @ResponseBody
    public String verificarJogosSicoob() {
        String concurso = "2220";
        ResultadoJogoWeb resultadoJogoWeb = new BasicWebCrawler().getInfo("https://confiraloterias.com.br/megasena/", concurso);

        if(resultadoJogoWeb == null) {
            return HTMLWrapper.montarSaidaResultadoAindaNaoDivulgado(concurso);
        }

        List<List<Resultado>> resultadosBoloes = new ArrayList<>();

        for(Bolao b : Collections.singletonList(BoloesCache.getBolao("Trabalho"))) {
            List<Resultado> resultados = ComparadorJogos.compararJogos(resultadoJogoWeb.getNumerosSorteados(), b);
            if(!resultados.isEmpty()) {
                resultadosBoloes.add(resultados);
            }
        }

        return HTMLWrapper.montarSaidaBoloes(resultadosBoloes);
    }

}
