package org.codingnojam.springbootjpastudy.repository.orderqeury;

import lombok.Data;
import org.codingnojam.springbootjpastudy.domain.OrderItem;

@Data
public class OrderItemQueryDto {
    private String name;
    private int count;
    private int price;

    public OrderItemQueryDto(String name, int count, int price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }
}
