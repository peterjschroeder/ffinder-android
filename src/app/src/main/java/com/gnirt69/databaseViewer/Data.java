package com.gnirt69.databaseViewer;

/**
 * Created by MG on 20/04/2017.
 */

public class Data {
    private String name, type, series, subseries, manufacturer, manufacturerNo, year, UPC, height, accessories, ageRange, genre, imageURL;

    public Data(String name, String type, String series, String subseries, String manufacturer,
                String manufacturerNo, String year, String UPC, String height,
                String accessories, String ageRange, String genre, String imageURL) {
        this.name = name;
        this.type = type;
        this.series = series;
        this.subseries = subseries;
        this.manufacturer = manufacturer;
        this.manufacturerNo = manufacturerNo;
        this.year = year;
        this.UPC = UPC;
        this.height = height;
        this.accessories = accessories;
        this.ageRange = ageRange;
        this.genre = genre;
        this.imageURL = imageURL;
    }
    public Data(String[] data)
    {
        this.name = data[0];;
        this.type = data[1];
        this.series = data[2];
        this.subseries = data[3];
        this.manufacturer = data[4];
        this.manufacturerNo = data[5];
        this.year = data[6];
        this.UPC = data[7];
        this.height = data[8];
        this.accessories = data[9];
        this.ageRange = data[10];
        this.genre = data[11];
        this.imageURL = data[12];
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getSeries() {
        return series;
    }
    public String getSubseries() { return subseries; }
    public String getManufacturer() { return manufacturer; }
    public String getManufacturerNo() {
        return manufacturerNo;
    }
    public String getYear() {
        return year;
    }
    public String getUPC() {
        return UPC;
    }
    public String getHeight() {
        return height;
    }
    public String getAccessories() {
        return accessories;
    }
    public String getAgeRange() { return ageRange; }
    public String getGenre() {
        return genre;
    }
    public String getImageURL() {
        return imageURL;
    }
}
