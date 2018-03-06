import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class IMDbScraper {
    public static void main(String[] args)throws Exception {

        final org.jsoup.nodes.Document document = Jsoup.connect("http://www.imdb.com/chart/top").get();
         //Print html of page
        //System.out.println(document.outerHtml());

        for(Element row : document.select("table.chart.full-width tr")){
            final String title = row.select(".titleColumn a").text();
            final String rating = row.select(".imdbRating").text();

            System.out.println(title + " --> Rating: "+ rating);
        }
    }
}





