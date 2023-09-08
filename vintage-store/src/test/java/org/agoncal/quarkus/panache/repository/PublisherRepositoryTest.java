package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.persistence.EntityNotFoundException;
import org.agoncal.quarkus.panache.model.Publisher;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PublisherRepositoryTest {


    @Test
    @TestTransaction
    void shouldCreateAndFindAnArtist() throws SQLException {
        long count = Publisher.count();
        int listAll = Publisher.listAll().size();
        assertEquals(count, listAll);

        Publisher publisher = new Publisher("name");

        Publisher.persist(publisher);
        assertNotNull(publisher.id);

        publisher = Publisher.findById(publisher.id);
        publisher = Publisher.findByName(publisher.name).orElseThrow(EntityNotFoundException::new);
        assertEquals("name", publisher.name);
        assertTrue(!Publisher.findContainingName("name").isEmpty());

        Publisher.deleteById(publisher.id);
        assertEquals(count, Publisher.count());
    }

}
