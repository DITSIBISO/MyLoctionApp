package com.example.android.myloctionapp.adminclasses;

/**
 * Created by eKasiLab Alex CDTB on 2018/02/09.
 */

public class Info {
    private String Event;
    private  String Location;
    private String DateTime;
    private  String description;

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
