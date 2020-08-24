package com.jojo.fragment;

public class News {
    private int id;
    private String title;
    private String detail;
    private String contributor;

    public News(int id, String title, String detail, String contributor) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.contributor = contributor;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }
}
