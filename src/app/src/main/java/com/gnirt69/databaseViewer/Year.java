package com.gnirt69.databaseViewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.gnirt69.databaseViewer.database.DatabaseHelper;

public class Year extends AppCompatActivity {
    ListView list;
    String manufacturer;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeas);


        list = (ListView) findViewById(R.id.yearsList);

        //receive which manufacturer was clicked
        Bundle extras = getIntent().getExtras();

        manufacturer = "";

        if (extras != null) {
            manufacturer = extras.getString("manufacturer");
        }


        //DatabaseAccess db = new DatabaseAccess(getBaseContext());
      //  String[] values = null;

        String[] values = new String[]{"years"};

        if (manufacturer != null) {
           // values = db.getYears(manufacturer);
            try {
                values = Manufacturer.toStringArr(Manufacturer.databaseHelper.showYear(manufacturer).toArray());

            } catch (Exception e) {

                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println("ERROR:  " + e.getMessage());
            }
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
                    //TODO filter upon year selected..

                    Intent i = new Intent(Year.this, MainActivity.class);
                    i.putExtra("year", itemValue);
                    i.putExtra("manufacturer", manufacturer);
                    startActivity(i);
                }

            });
        }
    }
}

