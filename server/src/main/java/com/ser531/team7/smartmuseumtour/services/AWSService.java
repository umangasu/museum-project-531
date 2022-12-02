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

    public Artwork getArtworkByID(String artworkID) {
        Artwork artwork = new Artwork();
        try (QueryExecution queryExecution = QueryExecutionFactory.sparqlService(ARTWORK_DS_URI, fuseki.getArtworkDetailsByArtworkId(artworkID))){
            ResultSet resultSet =  queryExecution.execSelect();
            while (resultSet.hasNext()) {
                QuerySolution solution = resultSet.nextSolution();
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
        }
        return artwork;
    }

    public List<Artwork> getAllArtworks() {
        List<Artwork> artworks = new ArrayList<>();
        try (QueryExecution queryExecution = QueryExecutionFactory.sparqlService(ARTWORK_DS_URI, fuseki.getAllArtworks())) {
            ResultSet resultSet =  queryExecution.execSelect();
            while (resultSet.hasNext()) {
                QuerySolution solution = resultSet.nextSolution();
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
        }
        return artworks;
    }

    public Artist getArtistByID(String artistID) {
        Artist artist = new Artist();
        try (QueryExecution queryExecution = QueryExecutionFactory.sparqlService(ARTIST_DS_URI, fuseki.getArtistDetailsByArtistId(artistID))) {
            ResultSet resultSet =  queryExecution.execSelect();
            while (resultSet.hasNext()) {
                QuerySolution solution = resultSet.nextSolution();
                System.out.println("Solution title : " + solution.getLiteral("Artist_Name").toString());
                artist.setArtistID(solution.getLiteral("Artist_id").toString());
                artist.setArtistName(solution.getLiteral("Artist_Name").toString());
                artist.setDescription(solution.getLiteral("Description").toString());
                artist.setBirthdate(solution.getLiteral("BirthDate").toString());
                artist.setNationality(solution.getLiteral("Nationality").toString());
            }
        }
        return artist;
    }

}

