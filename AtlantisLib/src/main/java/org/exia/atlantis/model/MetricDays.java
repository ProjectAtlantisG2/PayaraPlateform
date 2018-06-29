package org.exia.atlantis.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Azerom on 29/06/2018.
 */
public class MetricDays{

    public int dayNumber;
    public List<Object> points;

    public MetricDays(){

    }

    public void fake(){
        Random rand = new Random();
        this.dayNumber = rand.nextInt(30) + 1;
        this.points = new ArrayList<>();
        for(int i = 0; i < 15; i++){
            this.points.add(i);
        }
    }
}
