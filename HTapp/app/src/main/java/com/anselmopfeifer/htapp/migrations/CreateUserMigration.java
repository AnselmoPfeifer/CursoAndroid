package com.anselmopfeifer.htapp.migrations;

import android.database.sqlite.SQLiteDatabase;

import se.emilsjolander.sprinkles.Migration;

/**
 * Created by Anselmo on 03/11/2015.
 */
public class CreateUserMigration extends Migration {
    @Override
    protected void doMigration(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE user(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "email TEXT)"
        );
    }
}
