package dev.sameer.ecommerceorderservice.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PaymentRequestDTO {
    private double amount;
    private UUID orderId;
    private String description;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
}
