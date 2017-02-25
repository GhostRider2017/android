package com.ghostrider;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by anuraag on 2/25/17.
 */

public class Firebase {
    protected FirebaseDatabase database;

    public Firebase() {
        database = FirebaseDatabase.getInstance();
    }

    public FirebaseDatabase getDatabase() {
        return database;
    }


}
