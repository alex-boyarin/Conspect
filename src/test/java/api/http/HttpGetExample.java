package api.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

//Эти классы писать в MAIN src
public class HttpGetExample {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();// CloseableHttpClient-базавая реализ. интерф. HttpClients
        //   создается обьект http клиента
        HttpGet httpGet = new HttpGet("http://google.com");//созд. обьект класса HttpGet и в него передаем наш uri
        HttpResponse response = client.execute(httpGet);//(execute-выполнять) получаем ответ
        if (response.getStatusLine().getStatusCode() != 200) {//при помощи этих методов получ. статус код запроса
            throw new RuntimeException("massage" +          //выбрасываем новое искл. если статус не равен который мы хотим
                                       response.getStatusLine().getStatusCode() + " " +
                                       response.getStatusLine().getReasonPhrase());
        }
        String responseText = EntityUtils.toString(response.getEntity());//если в запросе было тело, то его можно взять
        //с помощью response.getEntity() дальше можно привести к стринге и посмотреть на текст ответа.
        System.out.println(responseText);
        client.close();
    }
}
