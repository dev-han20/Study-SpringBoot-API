package org.codingnojam.springbootjpastudy.repository;

import lombok.Data;
import org.codingnojam.springbootjpastudy.domain.Address;
import org.codingnojam.springbootjpastudy.domain.OrderStatus;
import java.time.LocalDateTime;

@Data
public class OrderQueryDto {

    private Long id;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;

    public OrderQueryDto(Long id, String name, LocalDateTime orderDate, OrderStatus orderStatus, Address address) {
        this.id = id;
        this.name = name;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.address = address;
    }
}
