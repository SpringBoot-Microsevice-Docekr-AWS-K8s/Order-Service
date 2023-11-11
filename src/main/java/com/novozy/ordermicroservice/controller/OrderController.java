package com.novozy.ordermicroservice.controller;

import com.novozy.ordermicroservice.dto.OrderDTO;
import com.novozy.ordermicroservice.dto.OrderDTOFromFE;
import com.novozy.ordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails){
        OrderDTO saveOrderToDB = orderService.saveOrderToDB(orderDetails);
        return new ResponseEntity<>(saveOrderToDB, HttpStatus.CREATED);
    }
}
