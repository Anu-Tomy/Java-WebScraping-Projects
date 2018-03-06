import org.jsoup.Jsoup;

public class IMDBScraper {
    public static void main(String[] args)throws Exception {
        final org.jsoup.nodes.Document document = Jsoup.connect("http://www.imdb.com").get();
        //Print html of page
        System.out.println(document.outerHtml());

    }


}
