package com.online.online.service;

import com.online.online.domain.Product;
import com.online.online.exception.ProductNotFoundException;
import com.online.online.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    /** encontrar producto por id y sino lanzara una excepcion**/
    @Override
    public Product findProduct(long id) throws ProductNotFoundException {
        /** elegimos el opcional id, por defecto **/
        return productRepository.findById(id).
                orElseThrow(ProductNotFoundException::new);

    }
}
