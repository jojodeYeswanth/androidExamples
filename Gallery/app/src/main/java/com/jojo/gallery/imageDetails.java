package com.jojo.gallery;

public class imageDetails {
    int id;
    byte [] image;

    imageDetails(){ }

    imageDetails(int id, byte[] image){
        this.id = id;
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
}
