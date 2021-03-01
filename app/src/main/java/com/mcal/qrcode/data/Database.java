package com.mcal.qrcode.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mcal.qrcode.App;

import org.jetbrains.annotations.NotNull;

public final class Database extends SQLiteOpenHelper {
    private static SQLiteDatabase database;

    public Database() {
        super(App.getContext(), "qrcode", null, 1);
        database = getWritableDatabase();
    }

    public static SQLiteDatabase getDatabase() {
        return database;
    }

    @Override
    public void onCreate(@NotNull SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ReadLessons (Number INTEGER PRIMARY KEY)");
        db.execSQL("CREATE TABLE Bookmarks (Number INTEGER PRIMARY KEY, Title TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("onUpgrade", ": " + db + ": " + oldVersion + ": " + newVersion);
    }
}