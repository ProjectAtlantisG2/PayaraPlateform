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
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;


@Component
public class MetricReceiver {

    @Autowired
    private DeviceRepository deviceRepository;


    public void receiveMessage(String message) {
        try {
        ObjectMapper mapper = new ObjectMapper();

        final Metric metric =  mapper.readValue(message, Metric.class);
        UUID uuid = UUID.fromString("e84bff53-3ceb-0274-d643-692bf1283aa9");
        Device device = deviceRepository.findByDeviceid(uuid);


            device.addMetric(metric);
            deviceRepository.save(device);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}