package dev.sameer.ecommerceorderservice.Service;

import dev.sameer.ecommerceorderservice.Client.PaymentClient;
import dev.sameer.ecommerceorderservice.Client.ProductClient;
import dev.sameer.ecommerceorderservice.Client.UserServiceClient;
import dev.sameer.ecommerceorderservice.DTO.OrderRequestDTO;
import dev.sameer.ecommerceorderservice.DTO.OrderResponseDTO;
import dev.sameer.ecommerceorderservice.DTO.PaymentRequestDTO;
import dev.sameer.ecommerceorderservice.DTO.ProductResponseDTO;
import dev.sameer.ecommerceorderservice.Entity.Order;
import dev.sameer.ecommerceorderservice.Entity.OrderItem;
import dev.sameer.ecommerceorderservice.Entity.User;
import dev.sameer.ecommerceorderservice.Enum.OrderStatus;
import dev.sameer.ecommerceorderservice.Exception.InvalidTokenException;
import dev.sameer.ecommerceorderservice.Mapper.EntityToDTO;
import dev.sameer.ecommerceorderservice.Repository.OrderItemRepository;
import dev.sameer.ecommerceorderservice.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private PaymentClient paymentClient;

    @Autowired
    private UserServiceClient userServiceClient;

    @Override
    public OrderResponseDTO createOrder(String token, OrderRequestDTO orderRequestDTO) {
        if (userServiceClient.validate(token)) {
            User user  = userServiceClient.extractUser(token);
            Order order = new Order();
            order.setCustomerId(user.getUserId());
            order.setOrderDate(LocalDate.now());
            order.setStatus(OrderStatus.PENDING);
            order.setShippingAddress(orderRequestDTO.getShippingAddress());
            order.setBillingAddress(orderRequestDTO.getBillingAddress());
            List<OrderItem> orderItemList = new ArrayList<>();
            double totalAmount = 0;
            for (UUID productId : orderRequestDTO.getProductList()) {
                ProductResponseDTO productResponseDTO = productClient.getProduct(productId);
                OrderItem item = new OrderItem(
                        productId, productResponseDTO.getTitle(), productResponseDTO.getPrice()
                );
                orderItemRepository.save(item);
                orderItemList.add(item);
                totalAmount += productResponseDTO.getPrice();
            }
            order.setProductList(orderItemList);
            order.setTotalAmount(totalAmount);
            orderRepository.save(order);
            PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
            paymentRequestDTO.setOrderId(order.getId());
            paymentRequestDTO.setAmount(totalAmount);
            paymentRequestDTO.setCustomerName(user.getUserName());
            paymentRequestDTO.setCustomerEmail(user.getUserEmail());
            paymentRequestDTO.setCustomerPhone(orderRequestDTO.getPhoneNumber());
            String link = paymentClient.doPayment(paymentRequestDTO);
            return EntityToDTO.convertOrderEntityToOrderDTO(order, link);
        }
        else
            throw new InvalidTokenException("Invalid token, Token might be expired");
    }
}
