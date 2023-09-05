package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.agoncal.quarkus.jpa.Customer;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class CustomerRepositoryTest {
    @Inject
    CustomerRepository customerRepository;

    @Test
    @TestTransaction
    void shouldCreateAndFindAnArtist() throws SQLException {
        Customer customer = new Customer("first_name", "last_name","email");

        assertTrue(customerRepository.listAllDans().size() <= customerRepository.count());

        customerRepository.persist(customer);
        assertNotNull(customer.getId());

        customer = customerRepository.findById(customer.getId());
        assertEquals("first_name", customer.getFirstName());
    }

}
