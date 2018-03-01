import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;



public class PeoplefindersScraper {
    public static void main(String[] args)throws Exception {

        final String lastName = "Smith";
        final String city = "New York";
        final String state = "NY";
        final HttpResponse<String> response = Unirest.get("https://www.peoplefinders.com/Widget/GetWidgets?&resultType=multiple")
            .queryString("ln", lastName)
            .queryString("city", city)
            .queryString("state", state).asString();

        System.out.println(response.getBody());



    }
}
