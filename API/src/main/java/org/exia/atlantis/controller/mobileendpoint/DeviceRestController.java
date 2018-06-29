package org.exia.atlantis.controller.mobileendpoint;

import org.exia.atlantis.model.Device;
import org.exia.atlantis.model.DeviceRepository;
import org.exia.atlantis.model.MetricMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Azerom on 29/06/2018.
 */
@RestController
@RequestMapping("/devices")
public class DeviceRestController {

    private final DeviceRepository deviceRepository;

    @Autowired
    DeviceRestController(DeviceRepository deviceRepository){
        this.deviceRepository = deviceRepository;
    }

    @GetMapping("/{deviceID}")
    HttpEntity<Device> readDevice(@PathVariable (required = true) String deviceID) {
        Device device = this.deviceRepository.findById(deviceID).get();
        return new ResponseEntity<Device>(device, HttpStatus.OK);
    }

    @GetMapping
    Device fake(){
        Device dev = new Device();
        dev.fake();
        deviceRepository.save(dev);
        return dev;
    }

}
