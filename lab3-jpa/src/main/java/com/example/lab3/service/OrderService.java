package com.example.lab3.service;

import com.example.lab3.dto.OrderDto;
import com.example.lab3.dto.OrderItemDto;
import com.example.lab3.entity.Order;
import com.example.lab3.entity.OrderItem;
import com.example.lab3.entity.Product;
import com.example.lab3.repository.OrderRepository;
import com.example.lab3.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;

    @Transactional
    public OrderDto create(OrderDto dto) {
        Order order = new Order();
        for (OrderItemDto itemDto : dto.items()) {
            Product product = productRepo.findById(itemDto.productId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found"));
            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(itemDto.quantity());
            item.setOrder(order);
            order.getItems().add(item);
        }
        Order saved = orderRepo.save(order);
        return toDto(saved);
    }

    @Transactional
    public OrderDto getById(Long id) {
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
        return toDto(order);
    }

    private OrderDto toDto(Order order) {
        List<OrderItemDto> itemDtos = new ArrayList<>();
        for (OrderItem item : order.getItems()) {
            itemDtos.add(new OrderItemDto(item.getId(), item.getProduct().getId(), item.getQuantity()));
        }
        return new OrderDto(order.getId(), order.getOrderDate(), itemDtos);
    }
}