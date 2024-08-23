package dev.sameer.ecommerceorderservice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private String title;
    private double price;
    private String description;
}
