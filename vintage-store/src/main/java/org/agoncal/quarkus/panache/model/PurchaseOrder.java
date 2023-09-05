package org.agoncal.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.agoncal.quarkus.jpa.Customer;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_purchase_orders")
public class PurchaseOrder extends PanacheEntity {
    @Column(name = "purchase_order_date")
    public LocalDate date;
    @OneToMany(mappedBy = "purchaseOrder")
    public List<OrderLine> orderLines = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "customer_fk")
    public Customer customer;
    @Column(name = "created_date", nullable = false)
    public Instant createdDate = Instant.now();

    public void addOrderLines(OrderLine orderLine) {
        this.orderLines.add(orderLine);
        orderLine.purchaseOrder = this;
    }
}
