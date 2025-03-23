package com.secor.ecommerceorderservice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Map;

@Getter
@Setter
public class Product
{
    @Id
    private String productid;
    private String name;
    private String description;
    private Double price;
    private String category;
}