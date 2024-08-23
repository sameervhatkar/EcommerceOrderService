package dev.sameer.ecommerceorderservice.Controller;

import dev.sameer.ecommerceorderservice.DTO.OrderRequestDTO;
import dev.sameer.ecommerceorderservice.DTO.OrderResponseDTO;
import dev.sameer.ecommerceorderservice.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("createOrder")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestHeader("Authorization") String token, @RequestBody OrderRequestDTO orderRequestDTO) {
        return ResponseEntity.ok(orderService.createOrder(token, orderRequestDTO));
    }
}
