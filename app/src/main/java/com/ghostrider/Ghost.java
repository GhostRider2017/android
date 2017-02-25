package com.ghostrider;

/**
 * Created by anuraag on 2/25/17.
 */

public class Ghost {
    private String timestamp;
    private int distance;
    private String time;
    private User user;

    public Ghost(User user, String timestamp, int distance, String time) {
        this.timestamp = timestamp;
        this.distance = distance;
        this.time = time;
        this.user = user;
    }

    public String getTimestamp() {

        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ghost{" +
                "timestamp='" + timestamp + '\'' +
                ", distance=" + distance +
                ", time='" + time + '\'' +
                ", user=" + user +
                '}';
    }
}
