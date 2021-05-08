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
    private static final String DATABASE_NAME = "patient_database";
    //Database Table Name
    private static final String TABLE_NAME = "PATIENT";
    //Table columns
    public static final String ID = "id";
    public static final String BLOOD = "blood_group";
    public static final String TYPE = "type";
    public static final String NAME = "name";
    public static final String PHNE = "phone";
    public static final String DET = "details";
    private SQLiteDatabase sqLiteDatabase;

    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT, "+BLOOD+" TEXT NOT NULL,"+TYPE+" TEXT NOT NULL,"+NAME+" TEXT NOT NULL,"+PHNE+" TEXT NOT NULL,"+DET+" TEXT);";

    //constructor
    public DatabaseHelperClass(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    //Add Request Data
    public void addRequest(RequestModelClass requestModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.BLOOD, requestModelClass.getBld());
        contentValues.put(DatabaseHelperClass.TYPE, requestModelClass.getTyp());
        contentValues.put(DatabaseHelperClass.NAME, requestModelClass.getName());
        contentValues.put(DatabaseHelperClass.PHNE, requestModelClass.getPhne());
        contentValues.put(DatabaseHelperClass.DET, requestModelClass.getDet());

        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME,null,contentValues);
    }

    public List<RequestModelClass> getRequestList(){
        String sql = "select * from "+ TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List <RequestModelClass> storeRequest = new ArrayList<>();
        Cursor curosr = sqLiteDatabase.rawQuery(sql, null);
        if (curosr.moveToFirst()){
            do{
                int id = Integer.parseInt(curosr.getString(0));
                String blood = curosr.getString(1);
                String type = curosr.getString(2);
                String name = curosr.getString(3);
                String phne = curosr.getString(4);
                String det = curosr.getString(5);
                storeRequest.add(new RequestModelClass(id, blood,type,name,phne,det));

            }while(curosr.moveToNext());
        }
        curosr.close();
        return storeRequest;
    }

    public void updateRequest (RequestModelClass requestModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.BLOOD, requestModelClass.getBld());
        contentValues.put(DatabaseHelperClass.TYPE, requestModelClass.getTyp());
        contentValues.put(DatabaseHelperClass.NAME, requestModelClass.getName());
        contentValues.put(DatabaseHelperClass.PHNE, requestModelClass.getPhne());
        contentValues.put(DatabaseHelperClass.DET, requestModelClass.getDet());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues, ID+"= ?",new String[]
                {String.valueOf(requestModelClass.getId())});
    }

    public void deleteRequest (int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME,ID+" =?", new String[]
                {String.valueOf(id)});
    }
}
