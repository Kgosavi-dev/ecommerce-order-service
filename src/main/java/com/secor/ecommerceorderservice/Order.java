package com.secor.ecommerceorderservice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "orders")
@Getter @Setter
public class Order
{

    @Id
    private String orderid;
    private String restro_id;
    private String username;
    private Map<String, Integer> dishes; // list of dish_id, quantity
    private String payment_id;
    private String status;

}
