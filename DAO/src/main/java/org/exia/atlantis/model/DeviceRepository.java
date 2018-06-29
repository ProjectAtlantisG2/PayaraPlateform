package org.exia.atlantis.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by Azerom on 29/06/2018.
 */
public interface DeviceRepository extends MongoRepository<Device, String> {

    public Device findByMacAddress(String mac_address);


}
