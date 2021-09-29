package org.codingnojam.springbootjpastudy.repository.orderqeury;

import lombok.Data;
import org.codingnojam.springbootjpastudy.domain.OrderItem;

@Data
public class OrderItemQueryDto {
    private Long orderId;
    private String name;
    private int count;
    private int price;

    public OrderItemQueryDto(String name, int count, int price, Long orderId) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.orderId = orderId;
    }
}
