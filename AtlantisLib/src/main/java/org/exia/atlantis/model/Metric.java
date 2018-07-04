package org.exia.atlantis.model;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by Azerom on 29/06/2018.
 */
public class Metric {

    public String deviceId;
    public String deviceType;
    public Calendar metricDate;
    public Object metricValue;

    public Metric(){

    }

    public Metric(JSONObject json){
        try {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/LL/yyyy HH:mm:ss:SSS", Locale.ENGLISH);

        this.deviceId = json.getString("deviceId");
        this.deviceType = json.getString("deviceType");
        this.metricDate = Calendar.getInstance();
        this.metricDate.setTime(sdf.parse(json.getString("metricDate")));
        this.metricValue = json.get("metricValue");

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void fake(String deviceId){
        this.deviceId = deviceId;
        this.metricDate = Calendar.getInstance();
        this.metricValue = 42;
    }
}
