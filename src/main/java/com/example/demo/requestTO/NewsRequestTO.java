package com.example.demo.requestTO;


import java.io.Serializable;

public class NewsRequestTO implements Serializable {
    private String title;

    private String description;

    private Integer tourIdOrMatchId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTourIdOrMatchId() {
        return tourIdOrMatchId;
    }

    public void setTourIdOrMatchId(Integer tourIdOrMatchId) {
        this.tourIdOrMatchId = tourIdOrMatchId;
    }
}
