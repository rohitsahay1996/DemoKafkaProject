package com.example.demoKafka.service;

import com.example.demoKafka.entity.Employee;

public interface ConsumerService {
    public void consumeEmployeeDetails(String data);
}
