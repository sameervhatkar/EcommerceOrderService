package dev.sameer.ecommerceorderservice.Client;

import dev.sameer.ecommerceorderservice.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class UserServiceClient {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${user.client.base.url}")
    private String userServiceClientApiBaseUrl;

    public boolean validate(String jwtToken) {
        String userServiceClientBaseUrl = userServiceClientApiBaseUrl.concat("/authenticate");

        RestTemplate restTemplate = restTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(jwtToken); // Set the JWT token in the Authorization header

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(
                userServiceClientBaseUrl,
                HttpMethod.GET,
                requestEntity,
                Boolean.class
        );

        return responseEntity.getBody();
    }

    public User extractUser(String token) {
        String userServiceClientBaseUrl = userServiceClientApiBaseUrl.concat("/extractUser");
        RestTemplate restTemplate = restTemplateBuilder.build();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<User> responseEntity = restTemplate.exchange(
                userServiceClientBaseUrl,
                HttpMethod.GET,
                requestEntity,
                User.class
        );

        return responseEntity.getBody();
    }
}