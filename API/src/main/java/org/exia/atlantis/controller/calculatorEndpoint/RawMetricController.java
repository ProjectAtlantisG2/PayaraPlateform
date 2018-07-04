package org.exia.atlantis.controller.calculatorEndpoint;

import org.exia.atlantis.model.Metric;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Azerom on 03/07/2018.
 */
@RestController
@RequestMapping("/rawmetric")
public class RawMetricController {

    @GetMapping("/{fromDate}/{toDate}")
    HttpEntity<List<Object>> getMetric(@PathVariable(required = true) String fromDate, @PathVariable(required = true) String toDate) {
        return null;
    }
}