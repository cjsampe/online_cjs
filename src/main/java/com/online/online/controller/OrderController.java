package com.online.online.controller;


import com.online.online.domain.Order;
import com.online.online.domain.Product;
import com.online.online.domain.User;
import com.online.online.exception.ProductNotFoundException;
import com.online.online.service.OrderService;
import com.online.online.service.ProductService;
import com.online.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @GetMapping("/add-order/{productId}")
    public String addOrder(@PathVariable long productId) throws ProductNotFoundException {
        Product product = productService.findProduct(productId);
        //TODO cambiar cuando implemetnemos la parte de seguridad
        User user = userService.findUser(1);
        orderService.addOrder(product, user);
        return "redirect:/product/" + productId;

    }

    @GetMapping("/my-orders")
    public String getOrders(Model model){
        User user = userService.findUser(1);
        List<Order> orders = orderService.findOrders(user);
        model.addAttribute("orders", orders);
        return "my-orders";
    }

    /** creamos un gestor de excepciones de productos **/
    @ExceptionHandler(ProductNotFoundException.class)
    public String handleException(HttpServletRequest request, ProductNotFoundException exception){
        return "error_product";
    }

}
