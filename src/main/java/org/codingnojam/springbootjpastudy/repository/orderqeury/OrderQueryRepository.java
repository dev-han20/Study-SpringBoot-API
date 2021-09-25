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
}
