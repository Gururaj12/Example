package com.example.dqtech.example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DQTECH on 08-Jan-18.
 */

public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String  DATABASE_NAME="wexos_info";
    public static final String  TABLE_EMP="employe";
    public static final String  ID="id";
    public static final String  NAME="name";
    public static final String  EMAIL="email";
    public static final String  USERNAME="username";
    public static final String  PASSWORD="password";

    SQLiteDatabase db;




    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_EMP + "("
                + ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"
                + EMAIL + "  TEXT," + USERNAME + " TEXT,"
                + PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

        /*String CREATE_TABLE_EMP=
                "create table student(id integer primary key not null ," +
                        "name text not null,email text,username text not null,password text not null);";
        db.execSQL(CREATE_TABLE_EMP);
*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String q="DROP IF TABLE EXISTS "+ TABLE_EMP;
        db.execSQL(q);
        onCreate(db);

    }

    public void insertdata(Contacts c){
        db=this.getWritableDatabase();



        ContentValues values=new ContentValues();

        String selectQuery = "SELECT * FROM " + TABLE_EMP;
       // String query="select * from" + TABLE_EMP;
        Cursor  cursor=db.rawQuery(selectQuery,null);
        int count=cursor.getCount();
        values.put("id",count);
        values.put("name",c.getName());
        values.put("email",c.getEmail());
        values.put("username",c.getUsername());
        values.put("password",c.getPassword());
        db.insert(TABLE_EMP,null,values);

    }
    public String searc(String username){
        db=this.getReadableDatabase();
        String query="SELECT username,password FROM " + TABLE_EMP;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        b="not found";
        if (cursor.moveToFirst()){
            do {
                 a=cursor.getString(0);

                if (a.equals(username)){
                     b=cursor.getString(1);

                }

            }while (cursor.moveToFirst());
        }
        return b;



    }
}
