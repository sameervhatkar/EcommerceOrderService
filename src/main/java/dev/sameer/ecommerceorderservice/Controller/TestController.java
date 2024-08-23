package dev.sameer.ecommerceorderservice.Controller;

import dev.sameer.ecommerceorderservice.Client.ProductClient;
import dev.sameer.ecommerceorderservice.DTO.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TestController {
    @Autowired
    private ProductClient productClient;

    @GetMapping("product/{productId}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable UUID productId) {
        ProductResponseDTO productResponseDTO = productClient.getProduct(productId);
        return ResponseEntity.ok(productResponseDTO);
    }
}
