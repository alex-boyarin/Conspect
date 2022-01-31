package api;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.net.http.HttpClient;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class PostExample {
    public static void main(String[] args) {
//        HttpClient client= HttpClients.createDefault();
//        HttpPost tokenRequest=new HttpPost(applicationUrI+"oauth/token");
//        tokenRequest.addHeader("Authorization", "Basic d2ViYXBwOg==");
//        List<NameValuePair> authParams=new ArrayList<>();
//        authParams.add(new BasicNameValuePair("username",username));
//        authParams.add(new BasicNameValuePair("password",password));
//        authParams.add(new BasicNameValuePair("grant_type","password"));
//        authParams.add(new BasicNameValuePair("scope","deltix.axa.user"));
//        tokenRequest.setEntity(new UrlEncodedFormEntity(authParams, Charset.defaultCharset()));
//        HttpResponse response = client.executor(tokenRequest);
//        if (response.getStatusLine().getStatusCode() != 200) {
//            throw new RuntimeException("Api login failed");
//        }
//        String responseText = EntityUtils.toString(response.getEntity());
    }
}
