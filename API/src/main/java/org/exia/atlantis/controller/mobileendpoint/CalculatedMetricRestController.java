package org.exia.atlantis.controller.mobileendpoint;

import org.exia.atlantis.config.WebSecurity;
import org.exia.atlantis.model.CalculatedMetric;
import org.exia.atlantis.model.Metric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Azerom on 30/06/2018.
 */
@RestController
@RequestMapping("/calculatedMetric")
public class CalculatedMetricRestController {

    @Autowired
    WebSecurity webSecurity;

    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping("/{metricID}")
    HttpEntity<CalculatedMetric> readCalculatedMetric(@PathVariable(required = true) String metricID) {
        CalculatedMetric metric = CalculatedMetric.fake(metricID);
        return new ResponseEntity<CalculatedMetric>(metric, HttpStatus.OK);
    }

    @GetMapping("/test")
    HttpEntity<Object> testJMS(){
        Metric metric = new Metric();
        metric.fake("5b3a19c8ae35f1091045f993");
        jmsTemplate.convertAndSend("mailbox", metric);
        return  new ResponseEntity<Object>(42, HttpStatus.OK);
    }



}
