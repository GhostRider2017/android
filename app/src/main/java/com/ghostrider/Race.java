package com.ghostrider;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by anuraag on 2/25/17.
 */

public class Race {
    private String creatorID;
    private ArrayList<Participant> participants;
    private String startTime;
    private int distance;
    private String state;
    private String id;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    private Result result;

    public Race(String creatorID, ArrayList<Participant> participants, int distance) {
        this.creatorID = creatorID;
        this.participants = participants;
        this.distance = distance;
        this.state = "created";
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void create(final Race race, final Context context) {

    }

    public String getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(String creatorID) {
        this.creatorID = creatorID;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Participant> participants) {
        this.participants = participants;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Race{" +
                "creatorID='" + creatorID + '\'' +
                ", participants=" + participants +
                ", startTime='" + startTime + '\'' +
                ", distance=" + distance +
                ", state='" + state + '\'' +
                ", id='" + id + '\'' +
                ", result=" + result +
                '}';
    }
}
