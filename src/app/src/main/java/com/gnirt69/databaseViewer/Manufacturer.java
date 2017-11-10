package com.gnirt69.databaseViewer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.gnirt69.databaseViewer.database.DatabaseHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Manufacturer extends Activity {


    ListView list;


    static DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_manufacturer);
        databaseHelper = new DatabaseHelper(this);

            //Check exists database
            File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
            if (false == database.exists()) {
                databaseHelper.getReadableDatabase();
                //Copy db
                if (copyDatabase(this)) {
                    Toast.makeText(this, "Copy database succes", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            //-----------------------------------------------------------------//

            list = (ListView) findViewById(R.id.listView);
            //-----------------------------------------------------------//
            String[] values = new String[]{"Manufacturer"};


            try {
                values = toStringArr(databaseHelper.getManufacturer().toArray());

            } catch (Exception e) {

                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println("ERROR:  " + e.getMessage());
            }


//        String[] values = new String[]{"Manufacturer"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, values);


            // Assign adapter to ListView
            list.setAdapter(adapter);


            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    // ListView Clicked item index
                    int itemPosition = position;

                    // ListView Clicked item value
                    String itemValue = (String) list.getItemAtPosition(position);
                    //TODO filter upon manufacturer selected..
                    Intent i = new Intent(Manufacturer.this, Year.class);
                    i.putExtra("manufacturer", itemValue);


                    startActivity(i);

                }

            });
        }

        public static String[] toStringArr (Object[]ob){
            String[] temp = new String[ob.length];
            for (int i = 0; i < ob.length; ++i) {
                temp[i] = (String) ob[i];
            }
            return temp;
        }



    private boolean copyDatabase(Context context) {
        try {

            InputStream inputStream = context.getAssets().open(DatabaseHelper.DBNAME);
            String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[]buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("MainActivity","DB copied");
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

