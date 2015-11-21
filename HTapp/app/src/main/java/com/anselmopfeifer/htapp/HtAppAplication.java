package com.anselmopfeifer.htapp;

import android.app.Application;

import com.anselmopfeifer.htapp.migrations.CreateUserMigration;

import se.emilsjolander.sprinkles.Sprinkles;

/**
 * Created by Anselmo on 03/11/2015.
 */
public class HtAppAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Sprinkles sprinkles = Sprinkles.init(getApplicationContext());
        sprinkles.addMigration(new CreateUserMigration());

    }
}
