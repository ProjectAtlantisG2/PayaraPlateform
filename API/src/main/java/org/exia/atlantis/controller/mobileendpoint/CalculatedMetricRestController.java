package org.exia.atlantis.controller.mobileendpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.exia.atlantis.config.WebSecurity;
import org.exia.atlantis.controller.dataendpoint.MetricReceiver;
import org.exia.atlantis.model.CalculatedMetric;
import org.exia.atlantis.model.Metric;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Created by Azerom on 30/06/2018.
 */
@RestController
@RequestMapping("/calculatedMetric")
public class CalculatedMetricRestController {

    private final RabbitTemplate rabbitTemplate;

    private final MetricReceiver receiver;

    public CalculatedMetricRestController (MetricReceiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/{metricID}")
    HttpEntity<CalculatedMetric> readCalculatedMetric(@PathVariable(required = true) String metricID) {
        CalculatedMetric metric = CalculatedMetric.fake(metricID);
        return new ResponseEntity<CalculatedMetric>(metric, HttpStatus.OK);
    }

    @GetMapping("/test")
    HttpEntity<Object> testJMS(){
        ObjectMapper mapper = new ObjectMapper();
        Metric metric = new Metric();
        metric.fake("5b3b704b41a52b2580679243");
        String json = null;
        try {
            json = mapper.writeValueAsString(metric);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        rabbitTemplate.convertAndSend("MetricsExchange", "metrics",json);

        return  new ResponseEntity<Object>( json, HttpStatus.OK);
    }



}
