package org.exia.atlantis.controller.dataendpoint;

/**
 * Created by Azerom on 01/07/2018.
 */

import org.exia.atlantis.model.DeviceRepository;
import org.exia.atlantis.model.Metric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class MetricReceiver {

    @Autowired
    DeviceRepository deviceRepository;

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Metric metric) {

        deviceRepository.findById(metric.deviceId).ifPresent( m -> { m.addMetric(metric); deviceRepository.save(m); });
    }

}