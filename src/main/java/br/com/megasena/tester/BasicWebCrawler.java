package br.com.megasena.tester;

import br.com.megasena.tester.model.ResultadoJogoWeb;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class BasicWebCrawler {

    public BasicWebCrawler() {

    }

    public ResultadoJogoWeb getInfo(String URL, String numeroConcurso) {
        try {
            ResultadoJogoWeb resultadoJogoWeb = new ResultadoJogoWeb();

            //1. Fetch the HTML code
            Document document = Jsoup.connect(URL).get();

            boolean isConcursoSelecionado = isConcurso(numeroConcurso, document);

            if(isConcursoSelecionado) {
                //2. Parse the HTML to extract numbers
                Elements linksOnPage = document.select(".kit-megasena");

                //3. Extrair números sorteados
                for (Element page : linksOnPage) {
                    resultadoJogoWeb.adicionarDezena(Integer.parseInt(page.childNode(0).attr("text")));
                }

                return resultadoJogoWeb;
            }
        } catch (IOException e) {
            System.err.println("For '" + URL + "': " + e.getMessage());
        }

        return null;
    }

    private boolean isConcurso(String numeroConcurso, Document document) {
        Elements elementos = document.select("h5.card-title");
        Element numeroConcursoElement = elementos.get(0);
        return !numeroConcursoElement.getElementsContainingText(numeroConcurso).isEmpty();
    }

    public static void main(String[] args) {
        //1. Pick a URL from the frontier
        new BasicWebCrawler().getInfo("https://confiraloterias.com.br/megasena/", "2219");
    }

}
