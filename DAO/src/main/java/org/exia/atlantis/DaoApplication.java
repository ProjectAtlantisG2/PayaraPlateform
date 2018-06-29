package org.exia.atlantis;

import org.exia.atlantis.model.Device;
import org.exia.atlantis.model.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DaoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<DaoApplication> applicationClass = DaoApplication.class;
}

@RestController
class GreetingController {

    @Autowired
    private DeviceRepository repository;

	@RequestMapping("/hello")
	String hello() {

	    Device dev = new Device();
        dev.fake();
	    repository.save(dev);

		return dev.toString();
	}
}