package com.magdamiu.firebaseforbeginners;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by magdamiu on 24/05/17.
 */

public class FirebaseForBeginnersApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
