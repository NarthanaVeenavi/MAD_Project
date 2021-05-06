package com.example.home;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME ="redwings_database";

    //Database Table Name
    private static final String TABLE_NAME = "CAMP";

    //Table columns
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String DATE = "date";
    public static final String TIME = "time";
    public static final String VENUE = "venue";
    public static final String DESCRIPTION = "description";
    private  SQLiteDatabase sqLiteDatabase;


    //create table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"( "+ ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NAME + " TEXT NOT NULL, " + PHONE + " TEXT NOT NULL, " + DATE + " TEXT NOT NULL, " + TIME + " TEXT NOT NULL, " + VENUE + " TEXT NOT NULL, " + DESCRIPTION + " TEXT NOT NULL);";

    //CONSTRUCTOR

    public DatabaseHelperClass(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    //Add Camp data
    public void addCamp(CampModelClass campModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.NAME, campModelClass.getName());
        contentValues.put(DatabaseHelperClass.PHONE, campModelClass.getPhone());
        contentValues.put(DatabaseHelperClass.DATE, campModelClass.getDate());
        contentValues.put(DatabaseHelperClass.TIME, campModelClass.getTime());
        contentValues.put(DatabaseHelperClass.VENUE, campModelClass.getVenue());
        contentValues.put(DatabaseHelperClass.DESCRIPTION, campModelClass.getDescription());

        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME, null,contentValues);

    }

    public List<CampModelClass> getCampList() {
        String sql = " select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<CampModelClass> storeCamp = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String phone = cursor.getString(2);
                String date = cursor.getString(3);
                String time = cursor.getString(4);
                String venue = cursor.getString(5);
                String description = cursor.getString(6);
                storeCamp.add(new CampModelClass(id,name,phone,date,time,venue,description));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeCamp;
    }

    //update Camp
    public void updateCamp(CampModelClass campModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.NAME,campModelClass.getName());
        contentValues.put(DatabaseHelperClass.PHONE,campModelClass.getPhone());
        contentValues.put(DatabaseHelperClass.DATE,campModelClass.getDate());
        contentValues.put(DatabaseHelperClass.TIME,campModelClass.getTime());
        contentValues.put(DatabaseHelperClass.VENUE,campModelClass.getVenue());
        contentValues.put(DatabaseHelperClass.DESCRIPTION,campModelClass.getDescription());

        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues, ID + " = ?" , new String[]
                {String.valueOf(campModelClass.getId())});
    }

    public void deleteCamp(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ?", new String[]
                {String.valueOf(id)});
    }

}
