package com.app;

import com.app.model.AnsweredQuestionnaire;
import com.app.model.Process;
import com.app.model.User;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.*;

@SpringBootApplication
public class FrontendAppUsingJavaApplication {




    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(FrontendAppUsingJavaApplication.class, args);

//        Process process1 =  new Process();
//        process1.setId(UUID.randomUUID());
//        process1.setProcessName("Some process name");
//
//
//        User user1 =  new User();
//        user1.setId(UUID.randomUUID());
//        user1.getProcesses().add(process1);
//
//        process1.getUsers().add(user1);
//
//        AnsweredQuestionnaire answeredQuestionnaire1 = new AnsweredQuestionnaire();
//        answeredQuestionnaire1.setId(UUID.randomUUID());
//        answeredQuestionnaire1.setProcess(process1);
//        process1.getAnsweredQuestionnaires().add(answeredQuestionnaire1);
//
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            String processJson = createJson(process1, mapper);
//            System.out.println("Converted json object is: "+processJson);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//-------------------------------------------------
        System.out.println("------------==============------------------");

//        var values = new HashMap<String, String>() {{
//            put("name", "John Doe");
//            put ("occupation", "gardener");
//        }};
//
//        var objectMapper = new ObjectMapper();
//        String requestBody = objectMapper
//                .writeValueAsString(process1);

//        HttpClient client = HttpClient.newHttpClient();
//        final CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        final HttpPost httpRequest = new HttpPost(new URIBuilder("http://localhost:8080/process").build());
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://localhost:8080/process"))
//                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                .build();
//
//        HttpResponse<String> response = client.send(request,
//                HttpResponse.BodyHandlers.ofString());
//        httpClient.execute(request);
//        System.out.println(response.body());

//        try {
//            String jsonResponse = executePost("http://localhost:8080/process", process1, new HashMap<>(), new HashMap<>());
//        }catch (Exception e){
//            System.out.println(e);
//        }


//        ResourceBundle test here
        System.out.println("Test here for resource bundle");
        Locale locale = new Locale("de", "DE");
        ResourceBundle bundle = ResourceBundle.getBundle("com.app.util.MyResourceBundle", locale);
        System.out.println(bundle.getString("test"));
    }

    public  static String executePost(
            final String url, final Object payLoad, final Map<String, String> headers,
            final Map<String, String> params) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        final CloseableHttpClient httpClient = HttpClientBuilder.create().build();


        // Add query strings to URL
        URIBuilder builder = new URIBuilder(url);

        for (final Map.Entry<String, String> elm : params.entrySet()) {
            builder = builder.setParameter(elm.getKey(), elm.getValue());
        }

        // can change for HttpPut, HttpPost, HttpPatch
        final HttpPost request = new HttpPost(builder.build());

        // Add headers from input map
        for (final Map.Entry<String, String> elm : headers.entrySet()) {
            request.addHeader(elm.getKey(), elm.getValue());
        }

        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        // Send Json String as body, can also send UrlEncodedFormEntity
        final StringEntity entity = new StringEntity(objectMapper.writeValueAsString(payLoad));
        request.setEntity(entity);

        try  {
            final CloseableHttpResponse response = httpClient.execute(request);
            System.out.println("Return response status code: "+response.getStatusLine().getStatusCode());
            System.out.println("Return response status code: "+response.getStatusLine());
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // Read response string using EntityUtils class of Apache http client library
                // Serialize json string into map or any other object
                return EntityUtils.toString(response.getEntity());
            } else {
                throw new Exception(EntityUtils.toString(response.getEntity()));
//                throw new Exception(String.format("Response status code was  and response was ",
//                        response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity())));
            }
        } catch (final ClientProtocolException e) {
            throw new Exception("Client protocol Exception occurred while executing request", e);
        } catch (final Exception e) {
            System.out.println(e);
            throw new Exception(e);
        }
    }


    public static <T> String createJson(T t, ObjectMapper objectMapper) throws JsonProcessingException {
        return objectMapper.writeValueAsString(t);
    }

}
