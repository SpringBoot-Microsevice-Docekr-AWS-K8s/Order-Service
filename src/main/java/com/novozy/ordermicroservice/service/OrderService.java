package com.novozy.ordermicroservice.service;

import com.novozy.ordermicroservice.dto.OrderDTO;
import com.novozy.ordermicroservice.dto.OrderDTOFromFE;
import com.novozy.ordermicroservice.dto.UserDTO;
import com.novozy.ordermicroservice.entity.Order;
import com.novozy.ordermicroservice.mapper.OrderMapper;
import com.novozy.ordermicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    SequenceGenerator sequenceGenerator;
    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saveOrderToDB(OrderDTOFromFE orderDetails) {
        Integer orderId = sequenceGenerator.generateNextOrderId();
        System.out.println(orderId);
        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSaved = new Order(orderId, orderDetails.getFoodItemList(), orderDetails.getRestaurant(), userDTO);
        orderRepository.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://user-service/user/fetchUserById/" + userId, UserDTO.class);
    }
}
