package com.gnirt69.databaseViewer;/**
 * Created by NgocTri on 11/7/2015.
 */

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle extras = getIntent().getExtras();
        String manufacturer = "", year = "";
        List<String[]> allData = null;
        if (extras != null) {
            manufacturer = extras.getString("manufacturer");
            year = extras.getString("year");
            allData = Manufacturer.databaseHelper.showDataWithYearAndManufacturer(manufacturer, year);
        }

        Data data = null;

        ManufactureData manufactureData = null;


        for (int i = 0; i < allData.size(); ++i) {

            data = new Data(allData.get(i));
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            manufactureData = new ManufactureData(data);

            fragmentTransaction.add(R.id.grid, manufactureData);
            fragmentTransaction.commit();

        }
        System.out.println("");
        //-------------------------------------------------------//

    }


}
