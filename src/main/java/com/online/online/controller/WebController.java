package com.online.online.controller;


import com.online.online.domain.Product;
import com.online.online.exception.ProductNotFoundException;
import com.online.online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class WebController {

    /** se declara aqui el productservice que trae los datos de la base de datos**/
    @Autowired
    private ProductService productService;

    /** son puntos de entrada **/
    @RequestMapping(value = "/")
    public String index(Model model){
        return "index";
    }

    @RequestMapping(value = "/catalog")
    public String catalog(Model model){
        /**lista todos los productos de la base de datos**/
        List<Product> allProducts = productService.findAllProducts();
        /** con esto se añade a la plantilla Product**/
        model.addAttribute("products", allProducts);
        return "catalog";
    }

    @RequestMapping(value = "/product/{id}")
    public String product(Model model, @PathVariable long id) throws ProductNotFoundException {
        Product product = productService.findProduct(id);
        model.addAttribute("product", product);
        return "product";
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public String handleException(HttpServletRequest request, ProductNotFoundException exception){
        return "error_product";
    }


    /** creamos un gestor de excepciones **/
    @ExceptionHandler
    public String handleException(HttpServletRequest request, Exception exception){

        return "error";
    }


}
