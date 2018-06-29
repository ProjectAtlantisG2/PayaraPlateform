package org.exia.atlantis.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Azerom on 29/06/2018.
 */
public class Device extends ResourceSupport {

    @Id
    public String id;

    public String macAddress;
    public Long elapsedBetweenPoints;

    public List<ApplicationUser> users;

    public String category;

    public String metric;

    public List<MetricMonth> data;

    @JsonCreator
    public Device(@JsonProperty("macAddress") String macAddress, @JsonProperty("elapsedBetweenPoints") Long elapsedBetweenPoints,
                    @JsonProperty("users") List<ApplicationUser> users, @JsonProperty("category") String category, @JsonProperty("metric") String metric,
                    @JsonProperty("data") List<MetricMonth> data) {
        this.macAddress = macAddress;
        this.elapsedBetweenPoints = elapsedBetweenPoints;
        this.users = users;
        this.category = category;
        this.metric = metric;
        this.data = data;
    }


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
        this.users = new ArrayList<ApplicationUser>();
    }

    @Override
    public String toString() {
        return String.format(
                "Device[id=%s, macAddress='%s', elapsedBetweenPoints='%s']",
                id, macAddress, elapsedBetweenPoints);
    }

}
