package org.codingnojam.springbootjpastudy.api;

import lombok.RequiredArgsConstructor;
import org.codingnojam.springbootjpastudy.domain.Order;
import org.codingnojam.springbootjpastudy.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderService orderService;

    @GetMapping("api/v1/orders")
    public List<Order> ordersV1() {
        List<Order> all = orderService.findAll();
        for (Order order : all) {
            order.getMember().getName();
            order.getDelivery().getAddress();
        }
        return all;
    }




}
