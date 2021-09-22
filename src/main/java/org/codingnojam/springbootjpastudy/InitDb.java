package org.codingnojam.springbootjpastudy;

import lombok.RequiredArgsConstructor;
import org.codingnojam.springbootjpastudy.domain.*;
import org.codingnojam.springbootjpastudy.domain.item.Book;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.initData1();
        initService.initData2();
    }

    @Component
    @RequiredArgsConstructor
    @Transactional
    static class InitService {

        private final EntityManager entityManager;

        public void initData1() {
            Member member = CreateMember("설현", "서울", "종로", "3333");
            entityManager.persist(member);

            Book book = createBook(15000, 30, "JPA1 book", "342515-353", "코딩노잼");
            entityManager.persist(book);

            Book otherBook = createBook(25000, 55, "JPA2 book", "9898-1231", "코노");
            entityManager.persist(otherBook);

            OrderItem orderItem = OrderItem.createOrderItem(book, book.getPrice(), 7);
            OrderItem otherOrderItem = OrderItem.createOrderItem(otherBook, otherBook.getPrice(), 3);

            Delivery delivery = createDelivery(member);
            Order order = Order.createOrder(member, delivery, orderItem, otherOrderItem);
            entityManager.persist(order);
        }

        public void initData2() {
            Member member = CreateMember("아이유", "경기도", "판교", "112");
            entityManager.persist(member);

            Book book = createBook(45000, 50, "SPRING1 book", "9348-124", "SM");
            entityManager.persist(book);

            Book otherBook = createBook(25000, 75, "SPRING2 book", "65474-1247", "YG");
            entityManager.persist(otherBook);

            OrderItem orderItem = OrderItem.createOrderItem(book, book.getPrice(), 7);
            OrderItem otherOrderItem = OrderItem.createOrderItem(otherBook, otherBook.getPrice(), 3);

            Delivery delivery = createDelivery(member);
            Order order = Order.createOrder(member, delivery, orderItem, otherOrderItem);
            entityManager.persist(order);
        }

        private Book createBook(int price, int quantity, String name, String isbn, String author) {
            Book book = new Book();
            book.setPrice(price);
            book.setStockQuantity(quantity);
            book.setName(name);
            book.setIsbn(isbn);
            book.setAuthor(author);
            return book;
        }

        private Member CreateMember(String name, String city, String street, String zipcode) {
            Member member = new Member();
            member.setName(name);
            member.setAddress(new Address(city, street, zipcode));
            return member;
        }

        private Delivery createDelivery(Member member) {
            Delivery delivery = new Delivery();
            delivery.setDeliveryStatus(DeliveryStatus.ING);
            delivery.setAddress(member.getAddress());
            return delivery;
        }


    }



}
