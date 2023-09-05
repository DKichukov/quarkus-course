package org.agoncal.quarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.agoncal.quarkus.jdbc.Artist;


@ApplicationScoped
public class ArtistRepository implements PanacheRepository<Artist> {
}
