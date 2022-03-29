import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Spotify {
    public static void main(String[] args) {
        //aaa();
        // }

        // public static void aaa() {
        String url = "https://accounts.spotify.com/authorize";
        RestAssured.given()
//                .contentType(ContentType.URLENC)
//                .header("Authorization", createBasicAuthHeaderValue())
                .queryParam("client_id", "5f2c049425c54727b0b171c1690fa99c")
                .queryParam("response_type", "code")
                .queryParam("redirect_uri", "https://localhost:8888/callback")
                .queryParam("scope", "playlist-modify-private playlist-read-collaborative playlist-read-private playlist-modify-public")
                .queryParam("show_dialog", "true")
                .log()
                //.parameters()
                .all()
                .when()
                .get(url)
                .then()
                .using()
                .log()
                .all();

    }

    private static String createBasicAuthHeaderValue() {
        String auth = String.format("%s:%s", "5f2c049425c54727b0b171c1690fa99c", "bf07677695f44b4db7ca3f67f774e09b");
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
        return "Basic " + new String(encodedAuth);
    }
}