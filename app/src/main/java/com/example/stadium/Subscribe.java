package com.example.stadium;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class Subscribe extends DataSupport {

    private int id;
    private String choose_date;
    private String choose_time;
    private String choose_sport;
    private Custom custom;

//    private Venues venues;
//    private List<Venues> venuesList = new ArrayList<Venues>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChoose_time() {
        return choose_time;
    }

    public void setChoose_time(String choose_time) {
        this.choose_time = choose_time;
    }

    public String getChoose_date() {
        return choose_date;
    }

    public void setChoose_date(String choose_date) {
        this.choose_date = choose_date;
    }

    public String getChoose_sport() {
        return choose_sport;
    }

    public void setChoose_sport(String choose_sport) {
        this.choose_sport = choose_sport;
    }

    //    public List<Venues> getVenuesList() {
//        return venuesList;
//    }
//
//    public void setVenuesList(List<Venues> venuesList) {
//        this.venuesList = venuesList;
//    }


//    public Venues getVenues() {
//        return venues;
//    }
//
//    public void setVenues(Venues venues) {
//        this.venues = venues;
//    }

    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }
}
