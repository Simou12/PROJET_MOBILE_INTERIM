package com.example.interim;

import com.google.firebase.auth.FirebaseUser;

public class CurrentUserManager {
    private static CurrentUserManager instance;
    private FirebaseUser currentUser;

    private CurrentUserManager() {
        // Private constructor to prevent instantiation
    }

    public static synchronized CurrentUserManager getInstance() {
        if (instance == null) {
            instance = new CurrentUserManager();
        }
        return instance;
    }

    public void setCurrentUser(FirebaseUser user) {
        this.currentUser = user;
    }

    public FirebaseUser getCurrentUser() {
        return currentUser;
    }
}
