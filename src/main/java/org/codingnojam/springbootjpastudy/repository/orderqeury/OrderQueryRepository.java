package org.codingnojam.springbootjpastudy.repository.orderqeury;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderQueryRepository {

    private final EntityManager em;

    public List<OrderQueryDto> findOrderDtos() {
        return em.createQuery("select new org.codingnojam.springbootjpastudy.repository.orderqeury.OrderQueryDto(o.id, m.name, o.orderDate, o.status, d.address) " +
                        "from Order o join o.member m join o.delivery d", OrderQueryDto.class)
                .getResultList();
    }

    public List<OrderCollectionQueryDto> findOrderCollections() {
        List<OrderCollectionQueryDto> list = findOrders();
        list.forEach(o -> o.setOrderItems(findOrderItems(o.getId())));
        return list;
    }

    public List<OrderCollectionQueryDto> findOrders() {
        return em.createQuery("select new org.codingnojam.springbootjpastudy.repository.orderqeury.OrderCollectionQueryDto(" +
                "o.id, m.name, o.orderDate, o.status, d.address) " +
                "from Order o " +
                "join o.member m " +
                "join o.delivery d"  , OrderCollectionQueryDto.class).getResultList();
    }

    public List<OrderItemQueryDto> findOrderItems(Long orderId) {
        return em.createQuery("select new org.codingnojam.springbootjpastudy.repository.orderqeury.OrderItemQueryDto(oi.item.name, oi.count, oi.orderPrice)" +
                "from OrderItem oi join oi.item i where oi.order.id = :orderId", OrderItemQueryDto.class).setParameter("orderId",orderId).getResultList();
    }


}
