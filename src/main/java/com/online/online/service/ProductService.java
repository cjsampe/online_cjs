package com.online.online.service;

import com.online.online.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> findAllProducts();
}
