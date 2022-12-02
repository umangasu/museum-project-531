package com.ser531.team7.smartmuseumtour.repository;

import org.springframework.stereotype.Service;

@Service
public class Fuseki {

    public String getArtworkDetailsByArtworkId(String artworkID) {
        return "PREFIX sem: <http://semanticweb.cs.vu.nl/2009/11/sem/>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX aw: <http://www.semanticweb.org/artwork#>\n" +
                "PREFIX semweb: <http://www.semanticweb.org/artwork/Artwork_1966.27.4>\n" +
                "\n" +
                "SELECT ?title ?bio ?image ?artworkID ?artistId ?artistName ?exhibitionId ?len ?wid ?ht  WHERE {\n" +
                " ?sub aw:hasArtworkDetails ?artist  .\n" +
                " filter (contains(str(?sub), \"Artwork_1966.27.4\")) \n" +
                " ?artist aw:hasTitle ?title .\n" +
                " ?artist aw:hasArtworkBio ?bio .\n" +
                " ?artist aw:hasImageUrl ?image . \n" +
                " ?artist aw:hasArtworkId ?artworkID .\n" +
                " ?sub aw:hasArtist ?artistWhole .\n" +
                " ?artist aw:hasType ?type .\n" +
                " ?artistWhole aw:hasArtistID ?artistId .\n" +
                " ?artistWhole aw:hasArtistName ?artistName .  \n" +
                " ?artist aw:hasSize ?size .\n" +
                " ?sub aw:exhibitedIn ?exhibit .\n" +
                " ?exhibit aw:hasExhibitionId ?exhibitionId . \n" +
                " ?size aw:hasWidth ?wid .\n" +
                " ?size aw:hasLength ?len .\n" +
                " ?size aw:hasHeight ?ht\n" +
                "}";
    }

    public String getAllArtworks() {
        return "PREFIX sem: <http://semanticweb.cs.vu.nl/2009/11/sem/>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX aw: <http://www.semanticweb.org/artwork#>\n" +
                "PREFIX semweb: <http://www.semanticweb.org/artwork/Artwork_1966.27.4>\n" +
                "\n" +
                "SELECT ?title ?bio ?image ?artworkID ?artistId ?artistName ?exhibitionId ?len ?wid ?ht ?dt  WHERE {\n" +
                " ?sub aw:hasArtworkDetails ?artist  .\n" +
                " filter (contains(str(?sub), \"Artwork_\")) \n" +
                " ?artist aw:hasTitle ?title .\n" +
                " ?artist aw:hasArtworkBio ?bio .\n" +
                " ?artist aw:hasImageUrl ?image . \n" +
                " ?artist aw:hasArtworkId ?artworkID .\n" +
                " ?sub aw:hasArtist ?artistWhole .\n" +
                " ?artist aw:hasType ?type .\n" +
                " ?artistWhole aw:hasArtistID ?artistId .\n" +
                " ?artistWhole aw:hasArtistName ?artistName .  \n" +
                " ?artist aw:hasSize ?size .\n" +
                " ?sub aw:exhibitedIn ?exhibit .\n" +
                " ?exhibit aw:hasExhibitionId ?exhibitionId . \n" +
                "  OPTIONAL {?size aw:hasWidth ?wid .} .\n" +
                "  OPTIONAL {?size aw:hasLength ?len .} .\n" +
                "  OPTIONAL {?size aw:hasHeight ?ht .}\n" +
                "  OPTIONAL { ?size aw:hasDiameter ?dt . }\n" +
                "}";
    }

    public String getArtistDetailsByArtistId(String artistId) {
        return "PREFIX sem: <http://semanticweb.cs.vu.nl/2009/11/sem/>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX ar: <http://www.semanticweb.org/artist#>\n" +
                "SELECT ?artistId ?artistName ?description ?birthDate ?nationality  WHERE {\n" +
                " ?sub  ar:hasartistDetails ?artistDetails .\n" +
                "   filter (contains(str(?sub), \"Artist_2484\"))\n" +
                " ?artistDetails ar:hasName ?artistName .\n" +
                " ?artistDetails ar:hasArtistId ?artistId . \n" +
                " ?artistDetails ar:hasdescription ?description . \n" +
                " ?artistDetails ar:hasbirthDate ?birthDate .  \n" +
                " ?sub ar:hasArtwork ?artwork .  \n" +
                " ?artwork ar:hasArtworkID ?artworkId .\n" +
                " ?sub ar:hasCountry ?country .\n" +
                " ?country ar:hasCountryName ?nationality\n" +
                "}";
    }
}
