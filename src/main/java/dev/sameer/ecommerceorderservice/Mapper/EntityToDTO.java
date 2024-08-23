package dev.sameer.ecommerceorderservice.Mapper;

import dev.sameer.ecommerceorderservice.DTO.OrderRequestDTO;
import dev.sameer.ecommerceorderservice.DTO.OrderResponseDTO;
import dev.sameer.ecommerceorderservice.Entity.Order;
import dev.sameer.ecommerceorderservice.Entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class EntityToDTO {
    public static OrderResponseDTO convertOrderEntityToOrderDTO(Order order, String link) {
        OrderResponseDTO responseDTO = new OrderResponseDTO();
        responseDTO.setCustomerId(order.getCustomerId());
        responseDTO.setOrderDate(order.getOrderDate());
        responseDTO.setStatus(order.getStatus());
        responseDTO.setTotalAmount(order.getTotalAmount());
        List<String> productNames = new ArrayList<>();
        for(OrderItem item : order.getProductList()) {
            productNames.add(item.getProductName());
        }
        responseDTO.setProductNameList(productNames);
        responseDTO.setBillingAddress(order.getBillingAddress());
        responseDTO.setShippingAddress(order.getShippingAddress());
        responseDTO.setPaymentLink(link);
        return responseDTO;
    }
}
