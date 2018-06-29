package org.exia.atlantis.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Azerom on 29/06/2018.
 */
public class Device {

    @Id
    public String id;

    public String macAddress;
    public Long elapsedBetweenPoints;

    public List<User> users;

    public String category;

    public String metric;

    public List<MetricMonth> data;


    public Device(){

    }

    public void fake(){
        Random rand = new Random();
        this.macAddress = String.valueOf(rand.nextInt() + rand.nextLong() + rand.nextDouble());
        this.elapsedBetweenPoints = rand.nextLong();
        this.category = "ipsum";
        this.metric = "lorem";
        this.data = new ArrayList<MetricMonth>();
        for(int i = 0; i < 12; i++){
            data.add(new MetricMonth());
        }
        this.users = new ArrayList<User>();
    }

    @Override
    public String toString() {
        return String.format(
                "Device[id=%s, macAddress='%s', elapsedBetweenPoints='%s']",
                id, macAddress, elapsedBetweenPoints);
    }

}
