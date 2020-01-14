package com.example.demoKafka.controller;

import com.example.demoKafka.service.EmployeeFileHandler;
import com.example.demoKafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafkaProject")
public class EmployeeController
{
    @Autowired
    EmployeeFileHandler employeeFileHandler;

    @Autowired
    ProducerService producerService;

    @GetMapping
    String getEmployeeDetail()
    {
        for(int itr=0;itr<100;itr++)
        {
            String employee = employeeFileHandler.readData(itr);
            producerService.produceEmployeeDetails(employee);
        }
        return "Success";
    }
}
