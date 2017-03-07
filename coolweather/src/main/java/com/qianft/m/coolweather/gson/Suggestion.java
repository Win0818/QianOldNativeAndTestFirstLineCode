package com.qianft.m.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/3/7.
 */

public class Suggestion {
    @SerializedName("comf")
    public Confort confort;

    @SerializedName("cw")
    public CarWash carWash;

    public Sport sport;

    public class Confort {
        @SerializedName("txt")
        public String info;
    }

    public class CarWash {
        @SerializedName("txt")
        public String info;
    }

    public class Sport {
        @SerializedName("txt")
        public String info;
    }
}
