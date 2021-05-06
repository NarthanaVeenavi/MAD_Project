package com.example.home;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperClass extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DB_NAME = "donor_database";
    private static final String TABLE_NAME = "donor";

    public static final String ID = "id";
    public static final String DATE = "date";
    public static final String VENUE = "venue";
    public static final String HEALTH = "health";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    private SQLiteDatabase sqLiteDatabase;


    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " " +
            "("
            +ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            +DATE + " TEXT,"
            +VENUE + " TEXT,"
            +HEALTH + " TEXT,"
            +TITLE + " TEXT,"
            +DESCRIPTION + " TEXT)"+
            ";";

    public DatabaseHelperClass(Context context){
        super(context,DB_NAME,null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE EXISTS" + TABLE_NAME);
        onCreate(db);
    }
    //Add Health Entry
    public void addHealthCard(HealthCardModelClass healthCardModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.DATE, healthCardModelClass.getDate());
        contentValues.put(DatabaseHelperClass.VENUE, healthCardModelClass.getVenue());
        contentValues.put(DatabaseHelperClass.HEALTH, healthCardModelClass.getHealth());
        contentValues.put(DatabaseHelperClass.TITLE, healthCardModelClass.getTitle());
        contentValues.put(DatabaseHelperClass.DESCRIPTION, healthCardModelClass.getDescription());

        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME, null, contentValues);
    }

    public List<HealthCardModelClass> getHealthCardList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<HealthCardModelClass> storeHealthCard = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String date = cursor.getString(1);
                String venue = cursor.getString(2);
                String health = cursor.getString(3);
                String title = cursor.getString(4);
                String description = cursor.getString(5);
                storeHealthCard.add(new HealthCardModelClass(id,date,venue,health,title,description));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return storeHealthCard;
    }
}