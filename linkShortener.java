import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import java.util.Scanner;

public class linkShortener {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter long url: ");
        String longUrl = sc.next();
        HttpResponse<String> response = Unirest.post("https://url-shortener-service.p.rapidapi.com/shorten")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("X-RapidAPI-Key", "YOUR_API")
                .header("X-RapidAPI-Host", "url-shortener-service.p.rapidapi.com")
                .body("url="+longUrl)
                .asString();
        String result = response.getBody();
        JsonObject jObj = JsonParser.parseString(result).getAsJsonObject();
        String shortUrl = jObj.get("result_url").toString();
        System.out.println("Short url: "+shortUrl);
    }

}
