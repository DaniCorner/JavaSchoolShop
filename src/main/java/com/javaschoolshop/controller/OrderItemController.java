package com.javaschoolshop.controller;

import com.javaschoolshop.dto.ProductQuantityDTO;
import com.javaschoolshop.entity.OrderItem;
import com.javaschoolshop.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/order-items")
public class OrderItemController {
        private final OrderItemService orderItemService;
        @Autowired
        public OrderItemController(OrderItemService orderItemService) {
            this.orderItemService = orderItemService;
        }
        @GetMapping("/product-quantities")
        public List<ProductQuantityDTO> getProductQuantitiesOrderedByTotalQuantity() {
            List<Object[]> productQuantities = orderItemService.getProductQuantitiesOrderedByTotalQuantity();
            List<ProductQuantityDTO> dtos = new ArrayList<>();

            for (Object[] result : productQuantities) {
                Long productId = (Long) result[0];
                String imageUrl = (String) result[1];
                Long totalQuantity = (Long) result[2];
                ProductQuantityDTO dto = new ProductQuantityDTO(productId, imageUrl, totalQuantity);
                dtos.add(dto);
            }
            return dtos;
        }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<OrderItem>> getOrderItemsByEmail(@PathVariable("email") String email) {
        List<OrderItem> orderItems = orderItemService.getOrderItemsByEmail(email);
        return ResponseEntity.ok(orderItems);
    }
}
