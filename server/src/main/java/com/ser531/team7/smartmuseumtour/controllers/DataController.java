package com.ser531.team7.smartmuseumtour.controllers;

import com.ser531.team7.smartmuseumtour.models.Artist;
import com.ser531.team7.smartmuseumtour.models.Artwork;
import com.ser531.team7.smartmuseumtour.models.Exhibition;
import com.ser531.team7.smartmuseumtour.services.AWSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    AWSService awsService;

    @CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*")
    @GetMapping("/smartMuseum/artworks")
    public List<Artwork> getArtworks() {
        return awsService.getAllArtworks();
    }

    @CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*")
    @GetMapping("/smartMuseum/artwork/{artworkId}")
    public Artwork getArtworkByID(@PathVariable String artworkId) {
        return awsService.getArtworkByID(artworkId);
    }

    @CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*")
    @GetMapping("/smartMuseum/artist/{artistId}")
    public Artist getArtistByID(@PathVariable String artistId) {
        return awsService.getArtistByID(artistId);
    }

    @CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*")
    @GetMapping("/smartMuseum/artists")
    public List<Artist> getArtists() {
        return awsService.getAllArtists();
    }

    @CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*")
    @GetMapping("/smartMuseum/exhibition/{exhibitionId}")
    public Exhibition getExhibitionByID(@PathVariable String exhibitionId) {
        return awsService.getExhibitionByID(exhibitionId);
    }
}
