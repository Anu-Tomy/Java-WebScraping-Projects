import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class UnirestTest {
    public static void main(String[] args) throws UnirestException {

        //Change the default user-agent header
        Unirest.setDefaultHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        //A simple get request to httpbin.org
        //final HttpResponse<String> response = Unirest.get("https://httpbin.org/get").asString();

        //Use a proxy
        //Unirest.setProxy(new HttpHost("61.135.217.12",80)); //Use for hiding your real identity

        final HttpResponse<JsonNode> getResponse = Unirest.get("https://httpbin.org/get").queryString("limit", 10).asJson();

        System.out.println(getResponse.getBody());
        System.out.println("IP address:  " + getResponse.getBody().getObject().getString("origin")); //returns IP address
        System.out.println("User-Agent:  " + getResponse.getBody().getObject().getJSONObject("headers").getString("User-Agent"));

        System.out.println("\n\n------------------------\n\n");

        //Make a post request with form data
        final HttpResponse<String> postResponseOne = Unirest.post("https://httpbin.org/post").field("postalcode", 12345).asString();

        System.out.println(postResponseOne.getBody());

        System.out.println("\n\n------------------------\n\n");

        //Make a post request with body data (Json)
        final JSONObject exampleJson = new JSONObject().put("postalcode", 12345);
        final HttpResponse<String> postResponseTwo = Unirest.post("https://httpbin.org/post").body(exampleJson).asString();

        System.out.println(postResponseTwo.getBody());


    }
}
