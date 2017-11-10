package com.gnirt69.databaseViewer;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class ManufactureData extends Fragment {

    Data data;

    public ManufactureData( ) {

    }

    @SuppressLint("ValidFragment")
    public ManufactureData(Data data) {
        // Required empty public constructor
        this.data = data;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manufacture_data, container, false);
        TextView name, type, series, subseries, manufacturer, manufacturerNo, year, UPC, height, accessories, ageRange, genre;

        ImageView itemImage = (ImageView)view.findViewById(R.id.imageView2);

        if (data.getImageURL() != null) {
            Picasso.with(getActivity()).load(data.getImageURL()).into(itemImage);

        }
        //extract items from Data field
        name = (TextView)view.findViewById(R.id.nameText);
        type = (TextView)view.findViewById(R.id.typeText);
        series = (TextView)view.findViewById(R.id.seriesText);
        subseries = (TextView)view.findViewById(R.id.subseriesText);
        manufacturer = (TextView)view.findViewById(R.id.manufacturerText);
        manufacturerNo = (TextView)view.findViewById(R.id.manufacturerNoText);
        year = (TextView)view.findViewById(R.id.yearText);
        UPC = (TextView)view.findViewById(R.id.UPCText);
        height = (TextView)view.findViewById(R.id.heightText);
        accessories = (TextView)view.findViewById(R.id.accessoriesText);
        ageRange = (TextView)view.findViewById(R.id.ageRangeText);
        genre = (TextView)view.findViewById(R.id.genreText);


        name.setText("Name: " +data.getName());
        type.setText("Type: " +data.getType());
        series.setText("Series: " +data.getSeries());
        subseries.setText("Subseries: " +data.getSubseries());
        manufacturer.setText("Manufacturer: " +data.getManufacturer());
        manufacturerNo.setText("Manufacturer #: " +data.getManufacturerNo());
        year.setText("Year Released: " +data.getYear());
        UPC.setText("UPC: " +data.getUPC());
        height.setText("Height: " +data.getHeight());
        accessories.setText("Accessories: " +data.getAccessories());
        ageRange.setText("Age Range: " +data.getAgeRange());
        genre.setText("Genres: " +data.getGenre());



        return view;
    }

}
