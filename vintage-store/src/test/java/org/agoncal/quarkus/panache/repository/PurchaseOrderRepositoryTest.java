package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.quarkus.jdbc.Artist;
import org.agoncal.quarkus.jpa.Customer;
import org.agoncal.quarkus.panache.model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

@QuarkusTest
class PurchaseOrderRepositoryTest {

    @Test
    @TestTransaction
    void shouldCreateAndFindAnPurchaseOrder() {

        CustomerRepository customerRepository = new CustomerRepository();

        //Create an Artist
        Artist artist = new Artist("artist_name", "artist_bio");
        //Create a Publisher
        Publisher publisher = new Publisher("publishe_name");
        //Create a Book
        Book book = new Book();
        book.title = "title of the book";
        book.nbOfPages = 500;
        book.price = new BigDecimal(10);
        book.isbn = "isbs";
        book.description = "book description";
        book.language = Language.ENGLISH;
        //Set relationships
        book.publisher = publisher;
        book.artist = artist;
        //Persist the book
        Book.persist(book);

        //create a customer
        Customer customer = new Customer("customer_first_name", "customer_last_name", "customer_email");
        customerRepository.persist(customer);

        //Create an Order line
        OrderLine orderLine = new OrderLine();
        orderLine.item = book;
        orderLine.quantity = 2;

        //Create a Purchase Order
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.customer = customer;
        purchaseOrder.addOrderLines(orderLine);

        PurchaseOrder.persist(purchaseOrder);
    }

}
