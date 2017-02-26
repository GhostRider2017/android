package com.ghostrider;

/**
 * Created by anuraag on 2/25/17.
 */

public class Result {
    public Result(User user) {
        this.user = user;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
