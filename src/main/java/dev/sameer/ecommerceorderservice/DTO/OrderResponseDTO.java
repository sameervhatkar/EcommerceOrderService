package dev.sameer.ecommerceorderservice.DTO;

import dev.sameer.ecommerceorderservice.Entity.OrderItem;
import dev.sameer.ecommerceorderservice.Enum.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderResponseDTO {
    private UUID customerId;
    private LocalDate orderDate;
    private OrderStatus status;
    private double totalAmount;
    private List<String> productNameList;
    private String shippingAddress;
    private String billingAddress;
    private UUID paymentId;
    private String paymentLink;
}
