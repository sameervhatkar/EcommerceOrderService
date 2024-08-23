package dev.sameer.ecommerceorderservice.Service;

import dev.sameer.ecommerceorderservice.DTO.OrderRequestDTO;
import dev.sameer.ecommerceorderservice.DTO.OrderResponseDTO;

public interface OrderService {
    OrderResponseDTO createOrder(String token,OrderRequestDTO orderRequestDTO);
}
