package api;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

//Эти классы писать в MAIN src
public class ApiExample {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();// CloseableHttpClient-базавая реализ. интерф. HttpClients
        //   создается обьект http клиента
        HttpGet httpGet = new HttpGet("http://google.com");//созд. обьект класса HttpGet и в него передаем наш uri
        HttpResponse response = client.execute(httpGet);//(execute-выполнять) получаем ответ
        if (response.getStatusLine().getStatusCode() != 200) {//при помощи этих методов получ. статус код запроса
            throw new RuntimeException("massage" +          //выбрасываем новое искл. если статус не равен который мы хотим
                                       response.getStatusLine().getStatusCode()
                                       + " " +
                                       response.getStatusLine().getReasonPhrase());
        }
        String responseText = EntityUtils.toString(response.getEntity());
        System.out.println(responseText);
        client.close();
    }
}
