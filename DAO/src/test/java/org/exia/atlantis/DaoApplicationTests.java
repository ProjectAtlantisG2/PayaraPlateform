package org.exia.atlantis;

import org.exia.atlantis.model.Device;
import org.exia.atlantis.model.DeviceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
public class DaoApplicationTests {

	@Autowired
	DeviceRepository repository;

	@Test
	public void fakeTest(){
		Device dev = new Device();
		dev.fake();

		repository.save(dev);
	}

}


