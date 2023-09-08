package org.agoncal.quarkus.panache.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.agoncal.quarkus.jdbc.Artist;
import org.agoncal.quarkus.panache.repository.ArtistRepository;

import java.util.List;

@Path("/api/aritst")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArtistResource {
    @Inject
    ArtistRepository artistRepository;

    @GET
    @Path("{id}")
    public Artist findArtistById(@PathParam("id") Long id) {
        return artistRepository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Artist> listAllArtists() {
        return artistRepository.listAll();
    }
}

