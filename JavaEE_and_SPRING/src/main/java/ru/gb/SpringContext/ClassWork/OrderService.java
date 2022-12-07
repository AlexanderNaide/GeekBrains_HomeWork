package ru.gb.SpringContext.ClassWork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

//    @Autowired
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void createOrderFromProduct(Long id){
        System.out.println("Заказ создан:");
        System.out.println(productService.getTitleById(id));
    }
}
