package com.example.product_order_app.controller;

import com.example.product_order_app.data.dto.OrderDTO;
import com.example.product_order_app.data.responseDTO.OrderResponseDTO;
import com.example.product_order_app.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Operation(summary = "주문 정보를 저장하는 API", description = "RequestBody로 주문 정보를 입력 받아 주문 요청")
    @PostMapping("/enroll")
    public ResponseEntity<String> createOrder(@Validated @RequestBody OrderDTO orderDTO){
        orderService.createOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Order has created");
    }

    @Operation(summary = "주문 정보를 수정하는 API", description = "주문 번호, 주문량, 상품 번호를 매개변수로 입력하여 주문 정보 수정")
    @PutMapping("/update")
    public ResponseEntity<String> updateOrder(@Validated @RequestParam Long orderId, Integer quantity, Long productId){
        orderService.updateOrder(orderId,quantity,productId);
        return ResponseEntity.status(HttpStatus.OK).body("orderId : " + orderId + " quantity : " + quantity + " productId : " + productId);
    }

    @Operation(summary = "주문 내역을 조회하는 API", description = "주문 번호를 통해 주문 내역을 조회")
    @GetMapping("/select")
    public ResponseEntity<OrderResponseDTO> findOrder(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findOrder(id));
    }

    @Operation(summary = "회원명으로 주문 리스트를 조회하는 API",description = "특정 회원이 주문한 모든 내역을 리스트로 조회")
    @GetMapping("/selectlist")
    public ResponseEntity<List<OrderResponseDTO>> findOrderList(@RequestParam String memberName){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findOrderList(memberName));
    }

    @Operation(summary = "주문을 취소하는 API", description = "주문 번호를 통해 주문 취소")
    @DeleteMapping("/delete")
    public ResponseEntity<String> cancelOrder(@RequestParam Long id){
        orderService.cancelOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body("Order has canceled");
    }
}
