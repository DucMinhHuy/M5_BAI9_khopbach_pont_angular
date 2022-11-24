package huy.bai911.module;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "productHuy")

public class Product {
    @Id
    private Long id;
    private String name;
    private int price;
    private String description;
}
