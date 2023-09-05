package org.agoncal.quarkus.jpa;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.sql.SQLException;

@ApplicationScoped
public class CustomerRepository {
    @Inject
    EntityManager entityManager;

    public void persist(Customer customer) throws SQLException {
        entityManager.persist(customer);
    }

    public Customer findById(Long id) throws SQLException {
        return entityManager.find(Customer.class, id);
    }
}
