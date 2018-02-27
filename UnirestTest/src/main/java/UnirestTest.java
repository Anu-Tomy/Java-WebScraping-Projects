import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UnirestTest {
    public static void main(String[] args) throws UnirestException {
        final HttpResponse<String> response = Unirest.get("https://httpbin.org/get").asString();

        System.out.println(response.getBody());
    }
}
