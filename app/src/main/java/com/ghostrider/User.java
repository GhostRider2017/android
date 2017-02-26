package com.ghostrider;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.content.ContentValues.TAG;

/**
 * Created by anuraag on 2/25/17.
 */

public class User {
    private static User currentUser;
    private String uid;
    private String name;
    private String password;
    private String email;
    private String picture;
    private String bio;
    private static boolean status;
    private static Toast message;

    private static FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private static FirebaseAuth.AuthStateListener mAuthListener;

    private static DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    public static User getCurrentUser() {
        return currentUser;
    }

    public User(FirebaseUser user) {
        this.email = user.getEmail();
        this.uid = user.getUid();
    }

    public static FirebaseAuth getMAuth() {
        return mAuth;
    }

    public static void login(final String email, final String password, final Context context) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity)context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        status = task.isSuccessful();
                        if(!status) {
                            message = Toast.makeText(context, task.getException().getMessage(), Toast.LENGTH_SHORT);
                        } else {
                            currentUser = new User(email, password);
                            message = Toast.makeText(context, "You have successfully logged in!", Toast.LENGTH_SHORT);
                        }
                        Log.e("status", task.isSuccessful() + "");
                        message.show();
                    }
                });
    }

    public static User register(final String name, final String email, final String password, final Context context) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        status = task.isSuccessful();
                        if(!status) {
                            message = Toast.makeText(context, task.getException().getMessage(), Toast.LENGTH_SHORT);
                        } else {
                            message = Toast.makeText(context, "You have successfully registered!", Toast.LENGTH_SHORT);
                            registerWithDB(name,email , password, task.getResult().getUser().getUid());
                        }
                        message.show();
                    }
                });
        if(status) {
            return new User(email, password);
        } else {
            return null;
        }
    }

    public static void registerWithDB(String name, String email, String password, String uid) {
        User user = new User(name, email, password);
        mDatabase.child("users").child(uid).setValue(user);
    }

    public User() {

    }

    public User(String email) {
        this.email = email;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.password = password;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public static void showToast() {
        message.show();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", picture='" + picture + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
