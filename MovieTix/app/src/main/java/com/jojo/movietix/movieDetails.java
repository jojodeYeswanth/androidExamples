package com.jojo.movietix;

public class movieDetails {
    String title;
    int rating, id;
    String releaseDate, genre;
    byte [] image;

    movieDetails(){ }

    movieDetails(int id, String title, String genre, byte[] image){
        this.title = title;
        this.id = id;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.rating = rating;
        this.image = image;
    }
    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
