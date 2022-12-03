package com.ser531.team7.smartmuseumtour.services;

import com.ser531.team7.smartmuseumtour.models.Artist;
import com.ser531.team7.smartmuseumtour.models.Artwork;
import com.ser531.team7.smartmuseumtour.models.Exhibition;
import com.ser531.team7.smartmuseumtour.repository.Fuseki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.jena.query.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static com.ser531.team7.smartmuseumtour.config.production.*;

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
                artwork.setArtworkID(solution.getLiteral("artworkID").toString());
                artwork.setArtistID(solution.getLiteral("artistId").toString().split(Pattern.quote("^^"))[0]);
                artwork.setTitle(solution.getLiteral("title").toString());
                artwork.setDescription(solution.getLiteral("bio").toString());
                artwork.setImageUrl(solution.getLiteral("image").toString());
                artwork.setHeight((solution.getLiteral("ht") == null ? "" : solution.getLiteral("ht").toString().split(Pattern.quote("^^"))[0]));
                artwork.setWidth((solution.getLiteral("wid") == null ? "" : solution.getLiteral("wid").toString().split(Pattern.quote("^^"))[0]));
                artwork.setDepth((solution.getLiteral("len") == null ? "" : solution.getLiteral("len").toString().split(Pattern.quote("^^"))[0]));
                artwork.setExhibitionId(solution.getLiteral("exhibitionId").toString().split(Pattern.quote("^^"))[0]);
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
                artwork.setArtworkID(solution.getLiteral("artworkID").toString());
                artwork.setArtistID(solution.getLiteral("artistId").toString().split(Pattern.quote("^^"))[0]);
                artwork.setTitle(solution.getLiteral("title").toString());
                artwork.setDescription(solution.getLiteral("bio").toString());
                artwork.setImageUrl(solution.getLiteral("image").toString());
                artwork.setHeight((solution.getLiteral("ht") == null ? "" : solution.getLiteral("ht").toString().split(Pattern.quote("^^"))[0]));
                artwork.setWidth((solution.getLiteral("wid") == null ? "" : solution.getLiteral("wid").toString().split(Pattern.quote("^^"))[0]));
                artwork.setDepth((solution.getLiteral("len") == null ? "" : solution.getLiteral("len").toString().split(Pattern.quote("^^"))[0]));
                artwork.setExhibitionId(solution.getLiteral("exhibitionId").toString().split(Pattern.quote("^^"))[0]);
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
                artist.setArtistID(solution.getLiteral("artistId").toString().split(Pattern.quote("^^"))[0]);
                artist.setArtistName(solution.getLiteral("artistName").toString());
                artist.setDescription(solution.getLiteral("description").toString());
                artist.setBirthdate(solution.getLiteral("birthDate").toString().split(Pattern.quote("^^"))[0]);
                artist.setNationality(solution.getLiteral("nationality").toString());
                artist.setImageUrl(solution.getLiteral("image").toString());
            }
        }
        return artist;
    }

    public List<Artist> getAllArtists() {
        List<Artist> artists = new ArrayList<>();
        try (QueryExecution queryExecution = QueryExecutionFactory.sparqlService(ARTIST_DS_URI, fuseki.getAllArtists())) {
            ResultSet resultSet =  queryExecution.execSelect();
            while (resultSet.hasNext()) {
                Artist artist = new Artist();
                QuerySolution solution = resultSet.nextSolution();
                artist.setArtistID(solution.getLiteral("artistId").toString().split(Pattern.quote("^^"))[0]);
                artist.setArtistName(solution.getLiteral("artistName").toString());
                artist.setDescription(solution.getLiteral("description").toString());
                artist.setBirthdate(solution.getLiteral("birthDate").toString().split(Pattern.quote("^^"))[0]);
                artist.setNationality(solution.getLiteral("nationality").toString());
                artist.setImageUrl(solution.getLiteral("image").toString());
                artists.add(artist);
            }
        }
        return artists;
    }

    public Exhibition getExhibitionByID(String exhibitionID) {
        Exhibition exhibition = new Exhibition();
        try (QueryExecution queryExecution = QueryExecutionFactory.sparqlService(EXHIBITION_DS_URI, fuseki.getExhibitionByExhibitionId(exhibitionID))) {
            ResultSet resultSet =  queryExecution.execSelect();
            while (resultSet.hasNext()) {
                QuerySolution solution = resultSet.nextSolution();
                exhibition.setExhibitionID(solution.getLiteral("exhibitionID").toString().split(Pattern.quote("^^"))[0]);
                exhibition.setExhibitionName(solution.getLiteral("exhibitionName").toString());
                exhibition.setExhibitionBio(solution.getLiteral("exhibitionBio").toString());
                exhibition.setFounders(solution.getLiteral("founders").toString());
                exhibition.setFoundedDate(solution.getLiteral("foundedDate").toString().split(Pattern.quote("^^"))[0]);
                exhibition.setArtworkId(solution.getLiteral("artworkId").toString().split(Pattern.quote("^^"))[0]);
                exhibition.setCountryName(solution.getLiteral("countryName").toString());
            }
        }
        return exhibition;
    }

}

