package org.exia.atlantis.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Azerom on 29/06/2018.
 */
public class Metric {

    public String deviceId;
    public Calendar timestamp;
    public Object data;

    public void fake(String deviceId){
        this.deviceId = deviceId;
        this.timestamp = Calendar.getInstance();
        this.data = 42;
    }
}
