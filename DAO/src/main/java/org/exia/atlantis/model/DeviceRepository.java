package org.exia.atlantis.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Azerom on 29/06/2018.
 */
public interface DeviceRepository extends MongoRepository<Device, String> {

    public Device findByMacAddress(String mac_address);
    public List<Device> findByIdEmployee(ObjectId idEmployee);
    public Device findByDeviceid(UUID deviceid);

}
