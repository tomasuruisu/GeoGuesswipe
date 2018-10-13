package com.thomas.geoguesswipe;

public class GeoObject {

    private boolean inEurope;
    private int geoImageName;
    private String geoImageLocation;

    public static final boolean[] PRE_DEFINED_GEO_OBJECT_VALUES = {
            true,
            false,
            false,
            true,
            false,
            true,
            true,
            false,
    };

    public static final int[] PRE_DEFINED_GEO_OBJECT_IMAGE_IDS = {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand,
    };

    public static final String[] PRE_DEFINED_GEO_OBJECT_NAMES = {
            "Denmark",
            "Canada",
            "Bangladesh",
            "Kazachstan",
            "Colombia",
            "Poland",
            "Malta",
            "Thailand"
    };

    public GeoObject(boolean inEurope, int geoImageName, String geoImageLocation) {
        this.inEurope = inEurope;
        this.geoImageName = geoImageName;
        this.geoImageLocation = geoImageLocation;
    }

    public boolean getmGeoName() {
        return inEurope;
    }

    public void setmGeoName(boolean inEurope) {
        this.inEurope = inEurope;
    }

    public int getGeoImageName() {
        return geoImageName;
    }

    public void setGeoImageName(int geoImageName) {
        this.geoImageName = geoImageName;
    }

    public String getGeoImageLocation() {
        return geoImageLocation;
    }

    public void setGeoImageLocation(String geoImageLocation) {
        this.geoImageLocation = geoImageLocation;
    }

}

