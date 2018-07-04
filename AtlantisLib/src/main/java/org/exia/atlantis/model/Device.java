package org.exia.atlantis.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;

import java.util.*;

/**
 * Created by Azerom on 29/06/2018.
 */
public class Device extends ResourceSupport {

    @Id
    public String id;

    public UUID deviceid;

    public String macAddress;
    public Long elapsedBetweenPoints;

    public ObjectId idEmployee;

    public String category;

    public String metric;

    public List<MetricMonth> data;

    public void addMetric(Metric metric){
        String month = Integer.toString(metric.metricDate.get(Calendar.YEAR) - 1900) + Integer.toString(metric.metricDate.get(Calendar.MONTH));
        int day = metric.metricDate.get(Calendar.DAY_OF_MONTH);
        int millisecond = metric.metricDate.get(Calendar.MILLISECOND) + metric.metricDate.get(Calendar.SECOND) * 1000 +
                metric.metricDate.get(Calendar.MINUTE) * 1000 * 60 + metric.metricDate.get(Calendar.HOUR_OF_DAY) * 1000 * 60 * 24;

        int monthIndex = -1;
        int dayIndex = -1;

        if(this.data == null)
            this.data = new ArrayList<MetricMonth>();

        //Finding Month
        for(MetricMonth m : this.data) {
            if (m.month.equals(month))
                monthIndex = this.data.indexOf(m);
        }
        if(monthIndex == -1){
            monthIndex = this.data.size();
            this.data.add(new MetricMonth(month));
        }

        //Finding Day
        for(MetricDays d : this.data.get(monthIndex).days){
            if(d.dayNumber == day)
                dayIndex = this.data.indexOf(d);
        }
        if(dayIndex == -1){
            dayIndex = this.data.get(monthIndex).days.size();
            this.data.get(monthIndex).days.add(new MetricDays(day));
        }

//        //Add missing points
//        while((this.data.get(monthIndex).days.get(dayIndex).points.size() * this.elapsedBetweenPoints) < millisecond){
//            this.data.get(monthIndex).days.get(dayIndex).points.add(null);
//        }
        //Add datapoint
        this.data.get(monthIndex).days.get(dayIndex).points.add(metric.metricValue);



    }


    public Device(){
        this.deviceid = UUID.randomUUID();
    }

    public void fake(){
        Random rand = new Random();
        this.macAddress = String.valueOf(rand.nextInt() + rand.nextLong() + rand.nextDouble());
        this.elapsedBetweenPoints = Long.valueOf(1000);
        this.category = "ipsum";
        this.metric = "lorem";
        this.data = new ArrayList<MetricMonth>();
        for(int i = 0; i < 1; i++){
            MetricMonth month = new MetricMonth("test");
            month.fake();
            data.add(month);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Device[id=%s, macAddress='%s', elapsedBetweenPoints='%s']",
                id, macAddress, elapsedBetweenPoints);
    }

}
