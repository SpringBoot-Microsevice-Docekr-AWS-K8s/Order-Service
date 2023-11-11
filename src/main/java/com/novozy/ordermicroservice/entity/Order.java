package com.novozy.ordermicroservice.entity;


import com.novozy.ordermicroservice.dto.FoodItemsDTO;
import com.novozy.ordermicroservice.dto.RestaurantDTO;
import com.novozy.ordermicroservice.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    private Integer orderId;
    private List<FoodItemsDTO> foodItemsList;
    private RestaurantDTO restaurant;
    private UserDTO userDTO;

}
