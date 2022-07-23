/**** Actividad Aprendizaje servidor_1 eval. ****/
/******** Maria Carmen Jimenez Samperiz  ********/

package com.online.online.repository;

import com.online.online.domain.Order;
import com.online.online.domain.Product;
import com.online.online.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** nos conecta con la base de datos DAO**/

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {


    /**  operaciones basicas **/

    List<Order> findAll();
    List<Order> findByUser(User user);
}
