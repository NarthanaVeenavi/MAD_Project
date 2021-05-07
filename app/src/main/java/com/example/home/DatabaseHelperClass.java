package com.example.home;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperClass extends SQLiteOpenHelper{

    //Database version
    private static final int DATABASE_VERSION = 1;

    //Database name
    private static final String DATABASE_NAME = "blood_donation_app_databse";

    //Database table name
    private static final String TABLE_NAME = "BLOOD_BANKS_DETAILS";
    private static final String TABLE_NAME2 = "EMERGENCY_NOTICES";
    private static final String TABLE_NAME3 = "BLOOD_TESTS";

    //Table columns
    public static final String ID = "id";
    public static final String BLOOD_BANK_NAME = "blood_bank_name";
    public static final String ADDRESS = "address";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String DISTRICT = "district";
    public static final String CITY = "city";
    public static final String POSTAL_CODE = "postal_code";
    public static final String USERNAME = "user_name";
    public static final String PASSWORD = "password";
    private SQLiteDatabase sqLiteDatabase;

    public static final String ID1 = "id1";
    public static final String HOSPITAL_NAME = "hospital_name";
    public static final String PHONE_NUM = "phone";
    public static final String DESCRIPTION = "description";

    public static final String ID2 = "id2";
    public static final String HOS_NAME = "hos_name";
    public static final String DATE = "date";
    public static final String TIME = "time";
    public static final String PHONE = "phone";
    public static final String BLOOD_TEST = "blood_tests";

    //creating table query

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +"( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BLOOD_BANK_NAME + " TEXT NOT NULL," + ADDRESS + " TEXT NOT NULL, "+
            PHONE_NUMBER + " TEXT NOT NULL, " + DISTRICT + " TEXT NOT NULL, " + CITY + " TEXT NOT NULL, " + POSTAL_CODE + " TEXT NOT NULL, " + USERNAME + " TEXT NOT NULL, " + PASSWORD + " TEXT NOT NULL)";

    private static final String CREATE_TABLE2 = " CREATE TABLE " + TABLE_NAME2 + "( " + ID1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + HOSPITAL_NAME + " TEXT NOT NULL, " + PHONE_NUM + " TEXT NOT NULL, " + DESCRIPTION + " TEXT NOT NULL)";

    private static final String CREATE_TABLE3 = " CREATE TABLE " + TABLE_NAME3 + "( " + ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + HOS_NAME + " TEXT NOT NULL, " + DATE + " TEXT NOT NULL, " + TIME + " TEXT NOT NULL, " + PHONE + " TEXT NOT NULL, " + BLOOD_TEST + " TEXT NOT NULL)";

    public DatabaseHelperClass(Context context){
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE2);
        db.execSQL(CREATE_TABLE3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME3);
        onCreate(db);
    }

    //Add blood bank details
    public void addBloodBanks(BloodBankDetailsModelClass bloodBankDetailsModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.BLOOD_BANK_NAME, bloodBankDetailsModelClass.getBloodBankName());
        contentValues.put(DatabaseHelperClass.ADDRESS, bloodBankDetailsModelClass.getAddress());
        contentValues.put(DatabaseHelperClass.PHONE_NUMBER, bloodBankDetailsModelClass.getPhone_number());
        contentValues.put(DatabaseHelperClass.DISTRICT, bloodBankDetailsModelClass.getDistrict());
        contentValues.put(DatabaseHelperClass.CITY, bloodBankDetailsModelClass.getCity());
        contentValues.put(DatabaseHelperClass.POSTAL_CODE, bloodBankDetailsModelClass.getPostalCode());
        contentValues.put(DatabaseHelperClass.USERNAME, bloodBankDetailsModelClass.getUsername());
        contentValues.put(DatabaseHelperClass.PASSWORD, bloodBankDetailsModelClass.getRePassword());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME, null,contentValues);
    }

    public void addBloodTests(BloodTestsModelClass bloodTestsModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.HOS_NAME, bloodTestsModelClass.getHos_name());
        contentValues.put(DatabaseHelperClass.DATE, bloodTestsModelClass.getDate());
        contentValues.put(DatabaseHelperClass.TIME, bloodTestsModelClass.getTime());
        contentValues.put(DatabaseHelperClass.PHONE, bloodTestsModelClass.getPhone());
        contentValues.put(DatabaseHelperClass.BLOOD_TEST, bloodTestsModelClass.getBlood_tests());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME3, null, contentValues);
    }

    public Boolean checkUserName(String USERNAME){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from BLOOD_BANKS_DETAILS where user_name = ?", new String[] { USERNAME });
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checkUsernamePassword(String USERNAME, String PASSWORD){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from BLOOD_BANKS_DETAILS where user_name = ? and password = ?", new String[] { USERNAME, PASSWORD });

        if(cursor.getCount()>0){

            return true;
        }
        else{
            return false;
        }
    }

    public void addEmergencyNotice(EmergencyNoticesModelClass emergencyNoticesModelClass){
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelperClass.HOSPITAL_NAME, emergencyNoticesModelClass.getHos_name());
        contentValue.put(DatabaseHelperClass.PHONE_NUM, emergencyNoticesModelClass.getPhone_num());
        contentValue.put(DatabaseHelperClass.DESCRIPTION, emergencyNoticesModelClass.getDescription());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME2, null,contentValue);
    }

    public List<EmergencyNoticesModelClass> getEmergencyNoticesList(){
        String sql = " select * from " + TABLE_NAME2;
        sqLiteDatabase = this.getReadableDatabase();
        List<EmergencyNoticesModelClass> storeEmergencyNotices = new ArrayList<>();

        //We can retrieve anything from database using an object of the Cursor class
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if(cursor.moveToFirst()) {
            do {
                int id1 = Integer.parseInt(cursor.getString(0));
                String hospital_name = cursor.getString(1);
                String phone = cursor.getString(2);
                String description = cursor.getString(3);
                storeEmergencyNotices.add(new EmergencyNoticesModelClass(id1, hospital_name, phone , description));
            } while (cursor.moveToNext());

        }
        cursor.close();
        return storeEmergencyNotices;

    }

    public List<BloodBankDetailsModelClass> getBloodBanksList(){
        String sql = " select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<BloodBankDetailsModelClass> storeBloodBanks = new ArrayList<>();

        //We can retrieve anything from database using an object of the Cursor class
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if(cursor.moveToFirst()) {
            do {
                String blood_bank_name = cursor.getString(1);
                String address = cursor.getString(2);
                String phone = cursor.getString(3);
                String district = cursor.getString(4);
                String city = cursor.getString(5);
                String postal_code = cursor.getString(6);
                storeBloodBanks.add(new BloodBankDetailsModelClass(blood_bank_name, address, phone, district, city, postal_code));

            } while (cursor.moveToNext());

        }
        cursor.close();
        return storeBloodBanks;

    }

    public void updateEmergencyNotices(EmergencyNoticesModelClass emergencyNoticesModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.HOSPITAL_NAME,emergencyNoticesModelClass.getHos_name());
        contentValues.put(DatabaseHelperClass.PHONE_NUM,emergencyNoticesModelClass.getPhone_num());
        contentValues.put(DatabaseHelperClass.DESCRIPTION,emergencyNoticesModelClass.getDescription());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME2, contentValues, ID1 + " = ? " , new String[] {String.valueOf(emergencyNoticesModelClass.getId())});
    }

    public void deleteEmergencyNotices(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME2, ID1 + " = ? ", new String[]{String.valueOf(id)});
    }

}
