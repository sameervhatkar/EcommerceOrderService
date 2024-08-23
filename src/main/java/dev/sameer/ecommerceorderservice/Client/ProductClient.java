package dev.sameer.ecommerceorderservice.Client;

import dev.sameer.ecommerceorderservice.DTO.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class ProductClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${product.client.base.url}")
    private String productBaseUrl;

    public ProductResponseDTO getProduct(UUID productId) {
        String productClientUrl = productBaseUrl.concat("/product/" + productId);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ProductResponseDTO productResponseDTO =
                restTemplate.getForObject(productClientUrl, ProductResponseDTO.class);
        return productResponseDTO;
    }


}
