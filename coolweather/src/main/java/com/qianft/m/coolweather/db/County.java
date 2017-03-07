package com.qianft.m.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/3/3.
 */

public class County extends DataSupport {

    private int id;
    private String countyName;
    private String weathreId;
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getWeathreId() {
        return weathreId;
    }

    public void setWeathreId(String weathreId) {
        this.weathreId = weathreId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
