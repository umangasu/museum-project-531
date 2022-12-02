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
    private String description;
    private String exhibitionId;
    private String artistName;

    public Artwork(String artworkID, String title, String height,
                   String width, String depth, String imageUrl,
                   String artistID, String description,
                   String exhibitionId, String artistName) {
        super();
        this.artworkID = artworkID;
        this.title = title;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.imageUrl = imageUrl;
        this.artistID = artistID;
        this.description = description;
        this.exhibitionId = exhibitionId;
        this.artistName = artistName;
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

    public String getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(String exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }



}
