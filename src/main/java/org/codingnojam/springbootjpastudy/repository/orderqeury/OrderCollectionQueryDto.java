package org.codingnojam.springbootjpastudy.repository.orderqeury;

import lombok.Data;
import org.codingnojam.springbootjpastudy.api.OrderCollectionApiController;
import org.codingnojam.springbootjpastudy.domain.Address;
import org.codingnojam.springbootjpastudy.domain.Order;
import org.codingnojam.springbootjpastudy.domain.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class OrderCollectionQueryDto {
    private Long id;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;
    private List<OrderItemQueryDto> orderItemQueryDtos;

    public OrderCollectionQueryDto(Long id, String name, LocalDateTime orderDate, OrderStatus orderStatus, Address address) {
        this.id = id;
        this.name = name;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.address = address;
    }
}
