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
    private static final int VERSION = 2;
    private static final String DB_NAME = "donor";
    private static final String TABLE_HEALTH = "health";
    private static final String TABLE_DONOR = "donor";

    public static final String ID = "id";
    public static final String DATE = "date";
    public static final String VENUE = "venue";
    public static final String HEALTH = "health";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";

    public static final String dID = "did";
    public static final String dNAME = "dname";
    public static final String dDOB = "ddob";
    public static final String dADDRESS = "daddress";
    public static final String dEMAIL = "demail";
    public static final String dPASSWORD = "dpassword";
    public static final String dBLOOD = "dblood";
    public static final String dNIC = "dnic";

    private SQLiteDatabase sqLiteDatabase;

    //Donor Table
    private static final String CREATE_TABLE_DONOR = "CREATE TABLE " + TABLE_DONOR + " " +
            "("
            + dID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            +dNAME + " TEXT,"
            +dDOB + " TEXT,"
            +dADDRESS + " TEXT,"
            +dEMAIL + " TEXT,"
            +dPASSWORD + " TEXT,"
            +dBLOOD + " TEXT,"
            +dNIC + " TEXT )"+
            ";";

    //Health Entry
    private static final String CREATE_TABLE_HEALTH = "CREATE TABLE " + TABLE_HEALTH + " " +
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
        db.execSQL(CREATE_TABLE_HEALTH);
        db.execSQL(CREATE_TABLE_DONOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE EXISTS" + TABLE_HEALTH);
        db.execSQL("DROP TABLE EXISTS" + TABLE_DONOR);

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
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_HEALTH, null, contentValues);
    }

    //Add Donor
    public void addDonor(DonorAccountModelClass donorAccountModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.dNAME, donorAccountModelClass.getdName());
        contentValues.put(DatabaseHelperClass.dDOB, donorAccountModelClass.getdDob());
        contentValues.put(DatabaseHelperClass.dADDRESS, donorAccountModelClass.getdAddress());
        contentValues.put(DatabaseHelperClass.dEMAIL, donorAccountModelClass.getdEmail());
        contentValues.put(DatabaseHelperClass.dPASSWORD, donorAccountModelClass.getdPassword());
        contentValues.put(DatabaseHelperClass.dBLOOD, donorAccountModelClass.getdBlood());
        contentValues.put(DatabaseHelperClass.dNIC, donorAccountModelClass.getdNic());

        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_DONOR, null, contentValues);
    }


    public List<HealthCardModelClass> getHealthCardList(){
        String sql = "select * from " + TABLE_HEALTH;
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

    //Donor
    public List<DonorAccountModelClass> getDonorList(){
        String sql = "select * from " + TABLE_DONOR;
        sqLiteDatabase = this.getReadableDatabase();
        List<DonorAccountModelClass> storeDonor = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                int did = Integer.parseInt(cursor.getString(0));
                String dname = cursor.getString(1);
                String ddob = cursor.getString(2);
                String daddress = cursor.getString(3);
                String demail = cursor.getString(4);
                String dpassword = cursor.getString(5);
                String dblood = cursor.getString(6);
                String dnic = cursor.getString(7);
                storeDonor.add(new DonorAccountModelClass(did,dname,ddob,daddress,demail,dpassword,dblood,dnic));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return storeDonor;
    }

public void updateHealthCard(HealthCardModelClass healthCardModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.DATE,healthCardModelClass.getDate());
        contentValues.put(DatabaseHelperClass.VENUE,healthCardModelClass.getVenue());
        contentValues.put(DatabaseHelperClass.HEALTH,healthCardModelClass.getHealth());
        contentValues.put(DatabaseHelperClass.TITLE,healthCardModelClass.getTitle());
        contentValues.put(DatabaseHelperClass.DESCRIPTION,healthCardModelClass.getDescription());


    sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_HEALTH,contentValues,ID + " = ?" , new String[]
                {String.valueOf(healthCardModelClass.getId())});
    }

    public void deleteHealthCard(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_HEALTH, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }

}

