package api.taskExample;

import io.restassured.http.ContentType;
import org.apache.commons.codec.binary.Base64;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiTokenRequestTest {
    private String url = "https://api-qa.dhlecommerce.com/account/v1/auth/accesstoken";
    private String productUri = "/account/v1/auth/accesstoken";

    @Test
    public void tokenHttpClientTest() {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet getTokenReq = new HttpGet(url);
        getTokenReq.setHeader(HttpHeaders.ACCEPT, "application/json");
        getTokenReq.setHeader(HttpHeaders.AUTHORIZATION, createBasicAuthHeaderValue());
        try {
            HttpResponse response = httpClient.execute(getTokenReq);
            Assertions.assertEquals(200, response.getStatusLine().getStatusCode());
            String body = EntityUtils.toString(response.getEntity());
            System.out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void tokenRestAssuredTest() {
        Map<String, String> respObj = given()
                .accept(ContentType.JSON)
                .header("Authorization", createBasicAuthHeaderValue())
                .log()
                .all()
                .when()
                .get(url)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("$");
        System.out.println(respObj);
    }
    @Test
    public void tokenRestAssuredTest1() {   //Для класса TokenResponse
        TokenResponse respObj = given()
                .accept(ContentType.JSON)
                .header("Authorization", createBasicAuthHeaderValue())
                .log()
                .all()
                .when()
                .get(url)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(TokenResponse.class);

        System.out.println(respObj);
    }


    private String createBasicAuthHeaderValue() {
        String auth = String.format("%s:%s", "e9ed82a8-4237-4185-8e36-47264aa9e718", "b1ed1bfa-689b-4d5b-bbf2-39dde64ccb64");
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
        return "Basic " + new String(encodedAuth);
    }
}
