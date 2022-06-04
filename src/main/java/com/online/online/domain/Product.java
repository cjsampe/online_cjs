package com.online.online.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**se debe importar esta, otra no valdra **/
import javax.persistence.*;
import java.time.LocalDateTime;

@Data /**se autogeneran los getters y setters **/

@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "products") /** marca que es una entidad y creara la tabla**/

public class Product {

    @Id
    /** autogenera el id**/
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
    @Column
    private LocalDateTime creationDate;
}
