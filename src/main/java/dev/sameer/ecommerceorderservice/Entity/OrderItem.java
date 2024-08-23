package dev.sameer.ecommerceorderservice.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class OrderItem extends BaseModel {
    private UUID productId;
    private String productName;
    private double unitPrice;

    public OrderItem(UUID productId, String productName, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
    }

    public OrderItem() {
    }
}
