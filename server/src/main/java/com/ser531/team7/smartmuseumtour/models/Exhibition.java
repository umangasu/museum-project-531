package com.ser531.team7.smartmuseumtour.models;

public class Exhibition {

    public Exhibition() {
        super();
    }

    private String exhibitionID;

    private String exhibitionName;

    private String exhibitionBio;

    private String founders;

    private String foundedDate;

    private String artworkId;

    private String countryName;

    public String getExhibitionID() {
        return exhibitionID;
    }

    public void setExhibitionID(String exhibitionID) {
        this.exhibitionID = exhibitionID;
    }

    public String getExhibitionName() {
        return exhibitionName;
    }

    public void setExhibitionName(String exhibitionName) {
        this.exhibitionName = exhibitionName;
    }

    public String getExhibitionBio() {
        return exhibitionBio;
    }

    public void setExhibitionBio(String exhibitionBio) {
        this.exhibitionBio = exhibitionBio;
    }

    public String getFounders() {
        return founders;
    }

    public void setFounders(String founders) {
        this.founders = founders;
    }

    public String getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(String foundedDate) {
        this.foundedDate = foundedDate;
    }

    public String getArtworkId() {
        return artworkId;
    }

    public void setArtworkId(String artworkId) {
        this.artworkId = artworkId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
