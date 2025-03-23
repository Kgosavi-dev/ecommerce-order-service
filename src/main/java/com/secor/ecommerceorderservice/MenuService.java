package com.secor.ecommerceorderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class MenuService {

    private static final Logger log = LoggerFactory.getLogger(MainRestController.class);


    @Autowired
    MenuItemRepository menuItemRepository;

    @Autowired
    @Qualifier("product-service-get-product")
    WebClient webClientProductService;


    public double calculateOrder(Order order)
    {

        log.info("Calculating total amount for order: {}", order);
        double total = 0;

        for(Map.Entry<String, Integer> entry : order.getProducts().entrySet())
        {

            log.info("Processing dish: {}", entry.getKey());

            Product product =  webClientProductService.get().uri("/"+entry.getKey()).retrieve().bodyToMono(Product.class).block();

//            MenuItem menuItem = menuItemRepository.findByDishid(entry.getKey());
//            log.info("Found menu item: {}", menuItem);

            if(product == null)
            {
                return -1;
            }

            total += product.getPrice() * entry.getValue(); // multiplying price with quantity
            log.info("Total amount so far: {}", total);
        }

        log.info("Total amount calculated: {}", total);
        return total;
    }


}
