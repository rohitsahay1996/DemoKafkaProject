package com.example.demoKafka.service;

import com.example.demoKafka.entity.Employee;

public interface ProducerService {
    public void produceEmployeeDetails(String empRecord);
}
