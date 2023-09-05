package org.agoncal.quarkus.jpa;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class CustomerRepositoryTest {
    @Inject
    CustomerRepository customerRepository;

    @Test
    @TestTransaction
    void shouldCreateAndFindAnArtist() throws SQLException {
        Customer customer = new Customer("first_name", "last_name","email");

        customerRepository.persist(customer);
        assertNotNull(customer.getId());

        customer = customerRepository.findById(customer.getId());
        assertEquals("first_name", customer.getFirstName());
    }

}
