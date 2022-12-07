package com.backend.genericpostpoc;

import com.backend.genericpostpoc.entity.Pojo;
import com.backend.genericpostpoc.util.Json;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication
public class GenericPostPocApplication {

    static RestTemplate restTemplate = new RestTemplate();
    static String baseUrl = "http://localhost:9093/";

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(GenericPostPocApplication.class, args);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Pojo pojo = Pojo.builder().firstName("Shashank").lastName("Srivastava")
                .address("Delhi").gender("Male").build();
        String str = Json.stringify(Json.toJsonNode(pojo));

        HttpEntity<String> requestEntity = new HttpEntity<>(str, headers);
//        makePostRequest(requestEntity);

        String userStr = "{\n" +
                "  \"name\" : \"John Doe\",\n" +
                "  \"address\" : {\n" +
                "    \"street\" : \"Home street\"\n" +
                "  }\n" +
                "}";

        HttpEntity<String> userRequestEntity = new HttpEntity<>(userStr, headers);
//        makePostRequest(userRequestEntity);

        String university = "{\n" +
                "  \"name\" : \"GLBITM\",\n" +
                "  \"students\" : [ {\n" +
                "    \"indexNumber\" : \"1111\"\n" +
                "  }, {\n" +
                "    \"indexNumber\" : \"2222\"\n" +
                "  } ]\n" +
                "}";
        HttpEntity<String> universityRequestEntity = new HttpEntity<>(university, headers);
//        makePostRequest(universityRequestEntity);

        String streaming = "[ {\n" +
                "  \"id\" : 3,\n" +
                "  \"nickName\" : \"John12\",\n" +
                "  \"followedStreams\" : [ {\n" +
                "    \"id\" : 1,\n" +
                "    \"name\" : \"CookingIsAwesome\",\n" +
                "    \"followers\" : [ ]\n" +
                "  } ]\n" +
                "}, {\n" +
                "  \"id\" : 4,\n" +
                "  \"nickName\" : \"WillM2\",\n" +
                "  \"followedStreams\" : [ {\n" +
                "    \"id\" : 2,\n" +
                "    \"name\" : \"ChillGaming\",\n" +
                "    \"followers\" : [ ]\n" +
                "  } ]\n" +
                "}, {\n" +
                "  \"id\" : 5,\n" +
                "  \"nickName\" : \"MightySam\",\n" +
                "  \"followedStreams\" : [ {\n" +
                "    \"id\" : 2,\n" +
                "    \"name\" : \"ChillGaming\",\n" +
                "    \"followers\" : [ ]\n" +
                "  }, {\n" +
                "    \"id\" : 1,\n" +
                "    \"name\" : \"CookingIsAwesome\",\n" +
                "    \"followers\" : [ ]\n" +
                "  } ]\n" +
                "} ]\n";
        HttpEntity<String> streamRequestEntity = new HttpEntity<>(streaming, headers);
        makePostRequest(streamRequestEntity);
    }

    private static void makePostRequest(HttpEntity<String> requestEntity) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "viewers",
                HttpMethod.POST,
                requestEntity,
                String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        String userDetails = responseEntity.getBody();
        System.out.println("response body - " + userDetails);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response Headers - " + responseHeaders);
    }

}
