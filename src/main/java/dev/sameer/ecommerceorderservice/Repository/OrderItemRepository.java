package dev.sameer.ecommerceorderservice.Repository;

import dev.sameer.ecommerceorderservice.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
}
