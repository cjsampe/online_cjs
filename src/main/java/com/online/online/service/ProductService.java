package com.online.online.service;

import com.online.online.domain.Product;
import com.online.online.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    /** listar todos los productos **/
    List<Product> findAllProducts();
    /** listar producto dado un id **/
    Product findProduct(long id) throws ProductNotFoundException;
}
