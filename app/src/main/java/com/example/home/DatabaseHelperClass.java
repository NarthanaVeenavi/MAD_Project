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
    private static final String TABLE_NAME2 = "ORGANIZATION";

    //Table columns
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String DATE = "date";
    public static final String TIME = "time";
    public static final String VENUE = "venue";
    public static final String DESCRIPTION = "description";
    private  SQLiteDatabase sqLiteDatabase;

    public static final String ID1 = "id1";
    public static final String ORGNAME = "orgname";
    public static final String ORGADDRESS = "address";
    public static final String ORGPNUM = "phonenumber";
    public static final String ORGDISTRICT = "district";
    public static final String ORGCITY = "city";
    public static final String ORGPOSTALCODE = "postalcode";
    public static final String ORGUSERNAME = "username";
    public static final String ORGPASSWORD = "password";


    //create table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"( "+ ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NAME + " TEXT NOT NULL, " + PHONE + " TEXT NOT NULL, " + DATE + " TEXT NOT NULL, " + TIME + " TEXT NOT NULL, " + VENUE + " TEXT NOT NULL, " + DESCRIPTION + " TEXT NOT NULL);";


    private static final String CREATE_TABLE2 = "create table " + TABLE_NAME2 +"( "+ ID1 +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            ORGNAME + " TEXT NOT NULL, " + ORGADDRESS + " TEXT NOT NULL, " + ORGPNUM + " TEXT NOT NULL, " + ORGDISTRICT + " TEXT NOT NULL, " + ORGCITY + " TEXT NOT NULL, " + ORGPOSTALCODE + " TEXT NOT NULL, " + ORGUSERNAME + " TEXT NOT NULL, " + ORGPASSWORD + " TEXT NOT NULL);";



    //CONSTRUCTOR

    public DatabaseHelperClass(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME2);
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

    //add organization data
    public void addOrganization(OrganizationModelClass organizationModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.ORGNAME, organizationModelClass.getOrgname());
        contentValues.put(DatabaseHelperClass.ORGADDRESS, organizationModelClass.getAddress());
        contentValues.put(DatabaseHelperClass.ORGPNUM, organizationModelClass.getPhonenumber());
        contentValues.put(DatabaseHelperClass.ORGDISTRICT, organizationModelClass.getDistrict());
        contentValues.put(DatabaseHelperClass.ORGCITY, organizationModelClass.getCity());
        contentValues.put(DatabaseHelperClass.ORGPOSTALCODE, organizationModelClass.getPostalcode());
        contentValues.put(DatabaseHelperClass.ORGUSERNAME, organizationModelClass.getUsername());
        contentValues.put(DatabaseHelperClass.ORGPASSWORD, organizationModelClass.getPassword());

        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME2, null,contentValues);

    }

    public Boolean checkusername(String username){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from ORGANIZATION where username = ?", new String[] { username });
        if(cursor.getCount()>0){

            return true;

        }
        else {

            return false;

        }

    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from ORGANIZATION where username = ? and password = ?", new String[] { username, password });
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
//update passwoed
    public Boolean updateusernamepassword(String username, String password){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = sqLiteDatabase.update("ORGANIZATION",contentValues,"username = ?", new String[] {username} );
        if(result == -1){
            return  false;
        }
        else{
            return  true;
        }

    }

    public List<OrganizationModelClass> getOrganizationList(){
        String sql = "select * from " + TABLE_NAME2;
        sqLiteDatabase = this.getReadableDatabase();
        List<OrganizationModelClass> storeOrganization = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                int id1 = Integer.parseInt(cursor.getString(0));
                String orgname = cursor.getString(1);
                String address = cursor.getString(2);
                String phonenumber = cursor.getString(3);
                String district = cursor.getString(4);
                String city = cursor.getString(5);
                String postalcode = cursor.getString(6);
                String username = cursor.getString(7);
                String password = cursor.getString(8);

                storeOrganization.add(new OrganizationModelClass(id1,orgname,address,phonenumber,district,city,postalcode,username,password));

            }while (cursor.moveToNext());
        }
        cursor.close();
        return  storeOrganization;
    }
}
