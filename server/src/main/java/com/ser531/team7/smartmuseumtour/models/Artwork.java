package com.ser531.team7.smartmuseumtour.models;

public class Artwork {

    public Artwork() {
        super();
    }

    private String artworkID;
    private String title;
    private String height;
    private String width;
    private String depth;
    private String imageUrl;
    private String artistID;
    private String artist;
    private String description;
    private String type;
    private String exhibitedIn;
    private String exhibitionId;

    public Artwork(String artworkID, String title, String height,
                   String width, String depth, String imageUrl,
                   String constituentID, String artist, String description,
                   String type, String exhibitedIn, String exhibitionId) {
        super();
        this.artworkID = artworkID;
        this.title = title;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.imageUrl = imageUrl;
        this.artistID = constituentID;
        this.artist = artist;
        this.description = description;
        this.type = type;
        this.exhibitedIn = exhibitedIn;
        this.exhibitionId = exhibitionId;
    }

    public String getArtworkID() {
        return artworkID;
    }

    public void setArtworkID(String artworkID) {
        this.artworkID = artworkID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getConstituentID() {
        return artistID;
    }

    public void setConstituentID(String constituentID) {
        this.artistID = constituentID;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtistID() {
        return this.artistID;
    }

    public void setArtistID(String artistID) {
        this.artistID = artistID;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExhibitedIn() {
        return exhibitedIn;
    }

    public void setExhibitedIn(String exhibitedIn) {
        this.exhibitedIn = exhibitedIn;
    }

    public String getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(String exhibitionId) {
        this.exhibitionId = exhibitionId;
    }



}
