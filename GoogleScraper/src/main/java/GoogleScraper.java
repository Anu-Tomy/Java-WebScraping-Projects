import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.PrintWriter;
import java.net.URLEncoder;

public class GoogleScraper  {
    //https://www.google.com/search?q=apple
    //Selector: h3.r.a

    //URLEncoder and USER_AGENT string is required if you get 403 HTTP error or get blocked
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36";
    public static void main(String[] args) throws Exception{
       final String query = "apple";
       final Document page = (Document) Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(query, "UTF-8")).userAgent(USER_AGENT).get();

       //Print html of page
       //System.out.println(page.outerHtml());

        for(Element searchResult : page.select("h3.r a")){
            final String title = searchResult.text();
            final String url = searchResult.attr("href");

            System.out.println(title + "-->" + url);

        }
        //PrintWriter saves/exports results to result.txt file
        final PrintWriter out = new PrintWriter("result.txt");

        for(Element searchResult : page.select("h3.r a")){
            final String title = searchResult.text();
            final String url = searchResult.attr("href");

            out.write(title + "-->" + url + "\n");
        }
        out.close();

    }
}
