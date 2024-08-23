package dev.sameer.ecommerceorderservice.Entity;

import dev.sameer.ecommerceorderservice.Enum.OrderStatus;
import jakarta.persistence.Entity;
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
@Entity(name = "Ecom_Order")
public class Order extends BaseModel {
    private UUID customerId;
    private LocalDate orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private double totalAmount;
    @ManyToMany
    private List<OrderItem> productList;
    private String shippingAddress;
    private String billingAddress;
    private UUID paymentId;
}

/*
    Order   OrderItem
       1        M
       M         1
 */
