package dev.sameer.ecommerceorderservice.DTO;

import dev.sameer.ecommerceorderservice.Entity.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderRequestDTO {
    private List<UUID> productList;
    private String shippingAddress;
    private String billingAddress;
    private String phoneNumber;
}
