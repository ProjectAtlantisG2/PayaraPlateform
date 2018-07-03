package org.exia.atlantis.controller.mobileendpoint;

import org.bson.types.ObjectId;
import org.exia.atlantis.model.ApplicationUser;
import org.exia.atlantis.model.Device;
import org.exia.atlantis.model.DeviceRepository;
import org.exia.atlantis.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;


/**
 * Created by Azerom on 29/06/2018.
 */
@RestController
@RequestMapping("/devices")
public class DeviceRestController {

    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;

    @Autowired
    DeviceRestController(DeviceRepository deviceRepository, UserRepository userRepository){
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/{uuid}")
    HttpEntity<Device> readDevice(@PathVariable (required = true) String uuid) {
        Device device = this.deviceRepository.findByUuid(UUID.fromString(uuid)).orElse(null);
        return new ResponseEntity<Device>(device, HttpStatus.OK);
    }

    @GetMapping
    HttpEntity<List<Device>> getAllUserDevice(@RequestHeader("Authorization") String authorization, Principal principal){
        ApplicationUser user = userRepository.findByEliotId(principal.getName()).orElse(null);
        List<Device> devices = deviceRepository.findByUsers(new ObjectId(user.getId()));
        return new ResponseEntity<List<Device>>(devices, HttpStatus.OK);
    }

    @GetMapping("/fake")
    Device fake(Principal principal){
        Device dev = new Device();
        ApplicationUser user = userRepository.findByEliotId(principal.getName()).orElse(null);

        dev.fake();
        dev.users.add(new ObjectId(user.getId()));
        deviceRepository.save(dev);
        return dev;
    }

}
