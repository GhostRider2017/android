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

import static android.content.ContentValues.TAG;

/**
 * Created by anuraag on 2/25/17.
 */

public class User extends Firebase {
    private String name;
    private String password;
    private String email;
    private String picture;
    private String bio;
    private static boolean status;
    private static Toast message;

    private static FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private static FirebaseAuth.AuthStateListener mAuthListener;


    public static User login(String email, String password, final Context context) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity)context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        status = task.isSuccessful();
                        if(!status) {
                            message = Toast.makeText(context, task.getException().getMessage(), Toast.LENGTH_SHORT);
                        } else {
                            message = Toast.makeText(context, "You have successfully logged in!", Toast.LENGTH_SHORT);
                        }
                        message.show();
                    }
                });
        if(status) {
            FirebaseUser fireBaseUser = mAuth.getCurrentUser();
            return new User(fireBaseUser.getDisplayName(), password, email);
        } else {
            return null;
        }
    }

    public static User register(String name, String email, String password, final Context context) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        status = task.isSuccessful();
                        if(!status) {
                            message = Toast.makeText(context, task.getException().getMessage(), Toast.LENGTH_SHORT);
                        } else {
                            message = Toast.makeText(context, "You have successfully registered!", Toast.LENGTH_SHORT);
                        }
                        message.show();
                    }
                });
        if(status) {
            return new User(name, password, email);
        } else {
            return null;
        }
    }

    public User() {

    }

    public User(String name, String password, String email) {
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
}
