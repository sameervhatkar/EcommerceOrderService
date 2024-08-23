package dev.sameer.ecommerceorderservice.Client;

import dev.sameer.ecommerceorderservice.DTO.PaymentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentClient {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${payment.client.base.url}")
    private String paymentClientApiBaseURL;

    public String doPayment(PaymentRequestDTO paymentRequestDTO) {
        String paymentBaseUrl = paymentClientApiBaseURL.concat("/payment");
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(paymentBaseUrl, paymentRequestDTO, String.class);
        return responseEntity.getBody();
    }
}
