package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.agoncal.quarkus.jdbc.Artist;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class ArtistRepositoryTest {
    @Inject
    ArtistRepository artistRepository;

    @Test
    @TestTransaction
    void shouldCreateAndFindAnArtist() {
        Artist artist = new Artist("name", "bio");

        artistRepository.persist(artist);
        assertNotNull(artist.getId());

        artist = artistRepository.findById(artist.getId());
        assertEquals("name", artist.getName());
    }

}
