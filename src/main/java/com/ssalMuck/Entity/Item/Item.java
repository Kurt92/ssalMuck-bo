package com.ssalMuck.Entity.Item;


import com.ssalMuck.Entity.Category;
import com.ssalMuck.Exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> catgories = new ArrayList<>();

    //비즈니스 로직
    /**
     * stock증가
     * */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * stock증가
     * */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if(restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
