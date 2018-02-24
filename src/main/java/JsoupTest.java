import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupTest {

    public static void main(String[] args) throws IOException {
        //Downloads the html from wikipedia and parses it
        final Document doc = Jsoup.connect("http://en.wikipedia.org/").get();

        //select a bunch of tags
        final Elements newsHeadlines = doc.select("#mp-itn b a");

        //print to console
        for (Element headline : newsHeadlines) {
            System.out.println(headline.text());
        }
    }
}
