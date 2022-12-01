package com.ser531.team7.smartmuseumtour.services;

import java.util.List;

import com.ser531.team7.smartmuseumtour.models.Artwork;
import org.springframework.stereotype.Service;
import org.apache.jena.query.*;
import java.util.ArrayList;

@Service
public class AWSService {

    private String artworkDSUri = "http://35.90.159.220:3030/persistent/query";
    private String artistDSUri = "http://35.89.87.20:3030/persistent/query";
    private String qrCodeDSUri = "http://35.90.159.220:3030/persistent/query";

    private String getArtworkDetailsByArtworkId(String artworkID) {
        return "PREFIX sem: <http://semanticweb.cs.vu.nl/2009/11/sem/>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX aw: <http://www.semanticweb.org/artwork#>\n" +
                "PREFIX semweb: <http://www.semanticweb.org/artwork/Artwork_1966.27.4>\n" +
                "\n" +
                "SELECT ?title ?bio ?image ?artworkID ?artistId ?exhibitionId ?len ?wid ?ht WHERE {\n" +
                " ?sub aw:hasArtworkDetails ?artist  .\n" +
                " filter (contains(str(?sub), \"Artwork_1966.27.4\")) \n" +
                " ?artist aw:hasTitle ?title .\n" +
                " ?artist aw:hasArtworkBio ?bio .\n" +
                " ?artist aw:hasImageUrl ?image . \n" +
                " ?artist aw:hasArtworkId ?artworkID .\n" +
                " ?sub aw:hasArtist ?artistWhole .\n" +
                " ?artistWhole aw:hasArtistID ?artistId . \n" +
                " ?artist aw:hasSize ?size .\n" +
                " ?sub aw:exhibitedIn ?exhibit .\n" +
                " ?exhibit aw:hasExhibitionId ?exhibitionId . \n" +
                " ?size aw:hasWidth ?wid .\n" +
                " ?size aw:hasLength ?len .\n" +
                " ?size aw:hasHeight ?ht \n" +
                "}";
    }

    private ResultSet executeQuery(String query, String uri) {
        System.out.println("Printing " + query);
        QueryExecution queryExecution = QueryExecutionFactory.sparqlService(uri, query);
        return queryExecution.execSelect();
    }

    public Artwork getArtworkByID(String artworkID) {
        ResultSet rs = executeQuery(getArtworkDetailsByArtworkId(artworkID), artworkDSUri);
        System.out.println("Resultset : " + rs.hasNext());
        Artwork artwork = new Artwork();
        while (rs.hasNext()) {
            QuerySolution solution = rs.nextSolution();
            System.out.println("Solution date : " + solution.getLiteral("title").toString());
            System.out.println("Solution date : " + solution.getLiteral("len").toString());
            artwork.setArtworkID(solution.getLiteral("artworkID").toString());
            artwork.setArtistID(solution.getLiteral("artistId").toString());
            artwork.setTitle(solution.getLiteral("title").toString());
            artwork.setDescription(solution.getLiteral("bio").toString());
            artwork.setImageUrl(solution.getLiteral("image").toString());
            artwork.setHeight(solution.getLiteral("ht").toString());
            artwork.setWidth(solution.getLiteral("wid").toString());
            artwork.setDepth(solution.getLiteral("len").toString());
//            artwork.setType(solution.getLiteral("type").toString());
            artwork.setExhibitedIn((solution.getLiteral("exhibit") == null ? "" : solution.getLiteral("exhibit")).toString());
            artwork.setExhibitionId(solution.getLiteral("exhibitionId").toString());
        }

//        setArtistInfo(artwork);
//        System.out.println(artwork);
        return artwork;
    }

//    public void setArtistInfo(Artwork artwork) {
//        String artistID = artwork.getArtistID();
//        ResultSet rs = executeQuery(queryArtistInfo(artistID), artistDSUri);
//        while (rs.hasNext()) {
//            QuerySolution solution = rs.nextSolution();
//            artwork.setArtist(solution.getLiteral("name").toString());
//        }
//    }
//
//    public Artwork getArtworkByQRCodeID(int id) {
//        ResultSet rs = executeQuery(queryByQRCodeID(id), qrCodeDSUri);
//        String artworkID = new String();
//        while (rs.hasNext()) {
//            QuerySolution solution = rs.nextSolution();
//            artworkID = solution.getLiteral("artworkIDVal").toString();
//            System.out.println("artwork ID : asda " + artworkID);
//        }
//
//        return getArtworkByID(Integer.toString(id));
//    }
}

