package org.exia.atlantis.controller.mobileendpoint;

import org.exia.atlantis.model.Device;
import org.exia.atlantis.model.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    Device readDevice(@PathVariable String deviceID) {
        return this.deviceRepository.findById(deviceID).get();
    }

    @GetMapping
    Device fake(){
        Device dev = new Device();
        dev.fake();
        deviceRepository.save(dev);
        return dev;
    }

}
