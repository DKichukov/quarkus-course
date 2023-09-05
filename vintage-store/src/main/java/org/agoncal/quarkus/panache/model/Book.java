package org.agoncal.quarkus.panache.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Book extends Item {
    @Column(length = 15)
    public String isbn;
    @Column(name = "bn_of_pages")
    public int nbOfPages;
    @Column(name = "publication_date")
    public LocalDate publicationDate;
    @Enumerated(EnumType.STRING)
    public Language language;
    @ManyToOne
    @JoinColumn(name = "publisher_fk")
    public Publisher publisher;
}
