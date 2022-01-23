package jpabook.jpashop.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class Book extends Item {

    private String author;
    private String isbn;

    @Builder
    public Book(String name, int price, int stockQuantity) {
        super.setName(name);
        super.setPrice(price);
        super.setStockQuantity(stockQuantity);
    }
}
