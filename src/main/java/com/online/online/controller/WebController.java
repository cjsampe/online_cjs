/**** Actividad Aprendizaje servidor_1 eval. ****/
/******** Maria Carmen Jimenez Samperiz  ********/
package com.online.online.controller;


import com.online.online.domain.Product;
import com.online.online.exception.ProductNotFoundException;
import com.online.online.service.ProductService;
import org.dom4j.rule.Mode;
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
    @GetMapping(value = "/")
    public String index(Model model){
        List<Product> allProducts = productService.findAllProducts();
        /** listamos ya productos en el index**/
        model.addAttribute("products", allProducts);
        return "index";
    }

    @GetMapping(value = "/catalog")
    public String catalog(Model model){
        /**lista todos los productos de la base de datos**/
        List<Product> allProducts = productService.findAllProducts();
        /** con esto se añade a la plantilla Product**/
        model.addAttribute("products", allProducts);
        return "catalog";
    }

    @GetMapping(value = "/product/{id}")
    public String product(Model model, @PathVariable long id) throws ProductNotFoundException {
        Product product = productService.findProduct(id);
        model.addAttribute("product", product);
        return "product";
    }

    /** busqueda por categoria **/
    @GetMapping(value = "/category/{categoryName}")
    public String productsByCategory(Model model, @PathVariable String categoryName){
        List<Product> categoryProduct = productService.findByCategory(categoryName);
        model.addAttribute("products", categoryProduct);
        /** para proporcionar informacion de en que categoria nos encontramos*/
        model.addAttribute("category" , categoryName);
        model.addAttribute("categoryList", true);
        model.addAttribute("category", categoryName);
        return "index";
    }

    /** creamos un gestor de excepciones de productos **/
    @ExceptionHandler(ProductNotFoundException.class)
    public String handleException(HttpServletRequest request, ProductNotFoundException exception){
        return "error_product";
    }


    /** creamos un gestor de excepciones generales **/
    @ExceptionHandler
    public String handleException(HttpServletRequest request, Exception exception){

        return "error";
    }


}
