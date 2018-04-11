package com.rekik.eventspeakecompositionapril;

import java.util.ArrayList;

public class Event {

    private String title;
    private String startDate;
    private String endDate;
    private ArrayList<Speaker> speakers;

    public void addSpeaker(Speaker speaker){
        speakers.add(speaker);
    }

    public Event() {
        speakers = new ArrayList<>();
    }

    public Event(String title) {
        this.title=title;
        speakers = new ArrayList<>();
    }

    public Event(String title, String startDate) {
        this.title=title;
        this.startDate=startDate;
        speakers = new ArrayList<>();
    }

    public Event(String title, String startDate, String endDate) {
        this.title=title;
        this.startDate=startDate;
        this.endDate=endDate;
        speakers = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate=startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate=endDate;
    }

    public ArrayList<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(ArrayList<Speaker> speakers) {
        this.speakers=speakers;
    }
}
