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

    public MetricDays(int dayNumber){
        this.dayNumber = dayNumber;
        this.points = new ArrayList<Object>();
    }

    public void fake(){
        Random rand = new Random();
        this.dayNumber = rand.nextInt(30) + 1;
        this.points = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            this.points.add(rand.nextInt(10) + 30);
        }
    }

    public void fake(int id){
        this.fake();
        this.dayNumber = id;
    }
}
