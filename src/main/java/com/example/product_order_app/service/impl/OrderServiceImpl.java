package com.example.product_order_app.service.impl;

import com.example.product_order_app.dao.MemberDAO;
import com.example.product_order_app.dao.OrderDAO;
import com.example.product_order_app.dao.ProductDAO;
import com.example.product_order_app.data.dto.OrderDTO;
import com.example.product_order_app.data.entity.Member;
import com.example.product_order_app.data.entity.Order;
import com.example.product_order_app.data.entity.Product;
import com.example.product_order_app.data.responseDTO.OrderResponseDTO;
import com.example.product_order_app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private MemberDAO memberDAO;
    @Autowired
    private ProductDAO productDAO;

    @Override
    public void createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        Member member = memberDAO.findMember(orderDTO.getMemberId());
        Product product = productDAO.findProduct(orderDTO.getProductId());
        //회원등급에 따라 할인가 적용(골드 30%, 실버 20%, 브론즈 10%), 비용은 주문수량 * 가격(할인 적용)
        Integer discountPrice = orderDTO.getQuantity() * (product.getPrice() * (100- member.getGrade().getDiscountRate())/100);

        order.setQuantity(orderDTO.getQuantity());
        order.setMember(member);
        order.setProduct(product);
        order.setCost(discountPrice);
        order.setMemberName(member.getName());
        order.setProductName(product.getName());

        orderDAO.createOrder(order);
    }

    @Override
    public OrderResponseDTO findOrder(Long orderId) {
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        Order foundOrder = orderDAO.findOrder(orderId);
        orderResponseDTO.setId(foundOrder.getId());
        orderResponseDTO.setQuantity(foundOrder.getQuantity());
        orderResponseDTO.setMemberName(foundOrder.getMember().getName());
        orderResponseDTO.setProductName(foundOrder.getProduct().getName());
        orderResponseDTO.setCost(foundOrder.getCost());
        return orderResponseDTO;
    }

    @Override
    public void updateOrder(Long orderId, Integer quantity, Long productId) {
        orderDAO.updateOrder(orderId,quantity,productId);
    }

    @Override
    public void cancelOrder(Long orderId) {
        orderDAO.cancelOrder(orderId);
    }

    @Override
    public List<OrderResponseDTO> findOrderList(String memberName) {
        List<OrderResponseDTO> responseDTOList = new ArrayList<>();
        List<Order> orderList = orderDAO.findOrderList(memberName);

        for(int i = 0; i < orderList.size(); i++){
            OrderResponseDTO responseDTO = new OrderResponseDTO();
            responseDTO.setId(orderList.get(i).getId());
            responseDTO.setQuantity(orderList.get(i).getQuantity());
            responseDTO.setMemberName(orderList.get(i).getMember().getName());
            responseDTO.setProductName(orderList.get(i).getProduct().getName());
            responseDTO.setCost(orderList.get(i).getCost());
            responseDTOList.add(responseDTO);
        }
        return responseDTOList;
    }
}
