package org.exia.atlantis.controller.dataendpoint;

/**
 * Created by Azerom on 01/07/2018.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.exia.atlantis.model.Device;
import org.exia.atlantis.model.DeviceRepository;
import org.exia.atlantis.model.Metric;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;


@Component
public class MetricReceiver {

    @Autowired
    private DeviceRepository deviceRepository;


    public void receiveMessage(String message) {
        try {
        ObjectMapper mapper = new ObjectMapper();

        final Metric metric =  mapper.readValue(message, Metric.class);


        deviceRepository.findById(metric.deviceId).ifPresent( m -> { m.addMetric(metric); deviceRepository.save(m); });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}