package com.example.demokafka.service.impl;

import com.example.demoKafka.document.Employee;
import com.example.demoKafka.service.ConsumerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService
{
    @Override
    @KafkaListener(topics = "employeeRecord", groupId = "group_id")
    public void consumeEmployeeDetails(String employee1)
    {
        try
        {
            ObjectMapper objectMapper = new ObjectMapper();
            Employee employee = objectMapper.readValue(employee1,Employee.class);
            System.out.println(employee);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //System.out.println(employee);
    }
}
