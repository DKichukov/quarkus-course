package org.agoncal.quarkus.jdbc;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class ArtistRepositoryTest {
    @Inject
    ArtistRepository artistRepository;

    @Test
    void shouldCreateAndFindAnArtist() throws SQLException {
        Artist artist = new Artist("name", "bio");

        artistRepository.persist(artist);
        assertNotNull(artist.getId());

        artist = artistRepository.findById(artist.getId());
        assertEquals("name", artist.getName());
    }

}
