package org.exia.atlantis.model;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Azerom on 30/06/2018.
 */
public class CalculatedMetric {
    private String id;
    private String userId;
    private String metricType;
    private Date calculDate;
    private List<Object> data;

    public static CalculatedMetric fake(String metricId){
        CalculatedMetric metric = new CalculatedMetric();
        metric.setId(metricId);
        metric.setUserId("84");
        metric.setMetricType("avg_t_byMonth");
        metric.setCalculDate(new Date());
        metric.setData(new ArrayList());

        return metric;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMetricType() {
        return metricType;
    }

    public void setMetricType(String metricType) {
        this.metricType = metricType;
    }

    public Date getCalculDate() {
        return calculDate;
    }

    public void setCalculDate(Date calculData) {
        this.calculDate = calculData;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
