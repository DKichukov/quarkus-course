package org.agoncal.quarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.agoncal.quarkus.jpa.Customer;


@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
}
