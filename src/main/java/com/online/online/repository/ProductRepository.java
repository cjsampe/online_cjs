package com.online.online.repository;

import com.online.online.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** nos conecta con la base de datos DAO**/

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {


    /**  operaciones basicas **/

    List<Product> findAll();
    Product findByName(String name);
    Product findByPrice(double price);
    List<Product> findByCategory(String category);
}
