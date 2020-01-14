package com.example.demoKafka.service.implementation;

import com.example.demoKafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceServiceImpl implements ProducerService
{
    private static final String TOPIC = "employeeRecord";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public void produceEmployeeDetails(String employee)
    {
        //System.out.println(employee.getLastName());
        this.kafkaTemplate.send(TOPIC,employee);
    }
}
