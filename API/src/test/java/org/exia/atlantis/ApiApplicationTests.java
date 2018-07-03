package org.exia.atlantis;

import com.mongodb.MongoClient;
import org.exia.atlantis.controller.dataendpoint.MetricReceiver;
import org.exia.atlantis.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
@SpringBootTest
public class ApiApplicationTests {

	@Configuration
	@EnableMongoRepositories
	static class ContextConfiguration {

		@Bean
		public MongoTemplate mongoTemplate() throws Exception {
			return new MongoTemplate(new MongoClient("localhost"), "test");
		}

		@Bean
		public MetricReceiver metricReceiver() throws Exception {
			return new MetricReceiver();
		}

	}

	@Autowired
	private DeviceRepository repository;

	@Autowired
	private MetricReceiver metricReceiver;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void fakeTest(){
		Device dev = new Device();
		dev.fake();

		repository.save(dev);
		Device getted = repository.findById(dev.id).orElse(null);
		assertEquals( getted, dev);
	}

//	@Test
//	public void insertTest(){
//		Device dev = new Device();
//		dev.fake();
//		repository.save(dev);
//		Metric metric = new Metric();
//		metric.fake(dev.id);
//
//		metricReceiver.receiveMessage(metric);
//
//		List<MetricMonth> months = repository.findById(dev.id).orElse(null).data;
//
//		List<MetricDays> days = months.get(months.size() - 1).days;
//
//		List<Object> data = days.get(days.size() - 1).points;
//
//		Object value = data.get(data.size() - 1);
//
//		assertEquals(value, metric.metricValue);
//	}

	@Test
	public void JMSTest(){

		Metric metric = new Metric();
		metric.fake("5b3a19c8ae35f1091045f993");


		// Send a message with a POJO - the template reuse the message converter
		System.out.println("Sending an email message.");
		jmsTemplate.convertAndSend(metric);
	}

}
