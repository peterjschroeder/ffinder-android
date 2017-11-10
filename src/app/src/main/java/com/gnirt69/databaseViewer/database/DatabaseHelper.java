package com.gnirt69.databaseViewer.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by NgocTri on 11/7/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "ActionFigures.sqlite";
    public static final String DBLOCATION = "/data/data/com.gnirt69.sqlitefromassetexample/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, 1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if(mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if(mDatabase!=null) {
            mDatabase.close();
        }
    }

    //manufacturers returned
    public List<String> getManufacturer(){

        List<String> man = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT distinct Manufacturer FROM ActionFigures order by Manufacturer ", null);

//        Cursor cursor1 = mDatabase.rawQuery("SELECT count( Manufacturer) FROM ActionFigures", null);
//        cursor1.moveToFirst();
//        System.out.println("lines: " + cursor1.getString(0));

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            man.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
//        closeDatabase();
        return man;
    }


    public List<String> showYear(String s)
    {
        List<String> year = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT distinct YearReleased FROM ActionFigures where Manufacturer = " + "\"" + s+ "\" order by YearReleased", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            year.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
//        closeDatabase();
        return year;
    }
    public List<String[]> showDataWithYearAndManufacturer(String manu, String year) {
        List<String[]> list = new ArrayList<>();


        Cursor cursor = mDatabase.rawQuery("SELECT * FROM ActionFigures where Manufacturer = \"" + manu + "\" and YearReleased = \"" + year + "\"", null);
        cursor.moveToFirst();
        String[] temp = null;
        while (!cursor.isAfterLast()) {
            temp = new String[13]; // FIXME: This number should be based on the size of Data
            for (int i = 0; i < 13; ++i) {
                temp[i] = cursor.getString(i);

            }
            list.add(temp);
            cursor.moveToNext();
        }
        cursor.close();

        return list;

    }


}
