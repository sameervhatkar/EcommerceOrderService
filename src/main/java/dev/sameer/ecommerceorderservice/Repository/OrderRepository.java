package dev.sameer.ecommerceorderservice.Repository;

import dev.sameer.ecommerceorderservice.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
}
