package com.ghostrider;

/**
 * Created by anuraag on 2/25/17.
 */

public class Participant {
    private int position;
    private int distance;
    private User user;

    public Participant(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "position=" + position +
                ", distance=" + distance +
                ", user=" + user +
                '}';
    }
}
