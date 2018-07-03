package org.exia.atlantis.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Azerom on 29/06/2018.
 */
public class MetricMonth {
    public String month;
    public List<MetricDays> days;

    public MetricMonth(){

    }
    public MetricMonth(String month){
        this.month = month;
        this.days = new ArrayList<MetricDays>();
    }

    public void fake(){
        Random rand = new Random();
        this.month = "lorem";
        this.days = new ArrayList<>();
        for (int i = 1; i < 7; i++){
            MetricDays md = new MetricDays();
            md.fake(i);
            days.add(md);
        }
    }
}
