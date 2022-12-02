package com.ser531.team7.smartmuseumtour.services;

import com.ser531.team7.smartmuseumtour.models.Artist;
import com.ser531.team7.smartmuseumtour.models.Artwork;
import com.ser531.team7.smartmuseumtour.repository.Fuseki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.jena.query.*;

import java.util.ArrayList;
import java.util.List;

import static com.ser531.team7.smartmuseumtour.config.production.ARTIST_DS_URI;
import static com.ser531.team7.smartmuseumtour.config.production.ARTWORK_DS_URI;

@Service
public class AWSService {

    @Autowired
    Fuseki fuseki;

    private ResultSet executeQuery(String query, String uri) {
        System.out.println("Printing " + query);
        QueryExecution queryExecution = QueryExecutionFactory.sparqlService(uri, query);
        return queryExecution.execSelect();
    }

    public Artwork getArtworkByID(String artworkID) {
        ResultSet rs = executeQuery(fuseki.getArtworkDetailsByArtworkId(artworkID), ARTWORK_DS_URI);
        Artwork artwork = new Artwork();
        System.out.println("Resultset : " + rs.hasNext());
        while (rs.hasNext()) {
            QuerySolution solution = rs.nextSolution();
            System.out.println("Solution title : " + solution.getLiteral("title").toString());
            artwork.setArtworkID(solution.getLiteral("artworkID").toString());
            artwork.setArtistID(solution.getLiteral("artistId").toString());
            artwork.setTitle(solution.getLiteral("title").toString());
            artwork.setDescription(solution.getLiteral("bio").toString());
            artwork.setImageUrl(solution.getLiteral("image").toString());
            artwork.setHeight((solution.getLiteral("ht") == null ? "" : solution.getLiteral("ht").toString()));
            artwork.setWidth((solution.getLiteral("wid") == null ? "" : solution.getLiteral("wid").toString()));
            artwork.setDepth((solution.getLiteral("len") == null ? "" : solution.getLiteral("len").toString()));
            artwork.setExhibitionId(solution.getLiteral("exhibitionId").toString());
            artwork.setArtistName(solution.getLiteral("artistName").toString());
        }
        return artwork;
    }

    public List<Artwork> getAllArtworks() {
        ResultSet rs = executeQuery(fuseki.getAllArtworks(), ARTWORK_DS_URI);
        List<Artwork> artworks = new ArrayList<>();
        System.out.println("Resultset : " + rs.hasNext());
        while (rs.hasNext()) {
            QuerySolution solution = rs.nextSolution();
            Artwork artwork = new Artwork();
            System.out.println("Solution title : " + solution.getLiteral("title").toString());
            artwork.setArtworkID(solution.getLiteral("artworkID").toString());
            artwork.setArtistID(solution.getLiteral("artistId").toString());
            artwork.setTitle(solution.getLiteral("title").toString());
            artwork.setDescription(solution.getLiteral("bio").toString());
            artwork.setImageUrl(solution.getLiteral("image").toString());
            artwork.setHeight((solution.getLiteral("ht") == null ? "" : solution.getLiteral("ht").toString()));
            artwork.setWidth((solution.getLiteral("wid") == null ? "" : solution.getLiteral("wid").toString()));
            artwork.setDepth((solution.getLiteral("len") == null ? "" : solution.getLiteral("len").toString()));
            artwork.setExhibitionId(solution.getLiteral("exhibitionId").toString());
            artwork.setArtistName(solution.getLiteral("artistName").toString());
            artworks.add(artwork);
        }
        return artworks;
    }

    public Artist getArtistByID(String artistID) {
        ResultSet rs = executeQuery(fuseki.getArtistDetailsByArtistId(artistID), ARTIST_DS_URI);
        Artist artist = new Artist();
        System.out.println("Resultset : " + rs.hasNext());
        while (rs.hasNext()) {
            QuerySolution solution = rs.nextSolution();
            System.out.println("Solution title : " + solution.getLiteral("title").toString());
            artist.setArtistID(solution.getLiteral("artistId").toString());
            artist.setArtistName(solution.getLiteral("artistName").toString());
            artist.setDescription(solution.getLiteral("description").toString());
            artist.setBirthdate(solution.getLiteral("birthDate").toString());
            artist.setNationality(solution.getLiteral("nationality").toString());
        }
        return artist;
    }

}

