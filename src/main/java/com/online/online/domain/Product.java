/**** Actividad Aprendizaje servidor_1 eval. ****/
/******** Maria Carmen Jimenez Samperiz  ********/

package com.online.online.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**se debe importar esta, otra no valdra **/
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data /**se autogeneran los getters y setters **/

@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "products") /** marca que es una entidad y creara la tabla**/

public class Product {

    @Id
    /** autogenera el id **/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String category;
    @Column
    private float price;
    @Column (name ="creation_date")
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "product")
    private List<Order> orders;
}
