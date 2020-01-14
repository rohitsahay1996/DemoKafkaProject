package com.example.demoKafka.controller;

import com.example.demoKafka.entity.Employee;
import com.example.demoKafka.service.EmployeeFileHandler;
import com.example.demoKafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafkaProject")
public class EmployeeController {

    @Autowired
    private EmployeeFileHandler employeeFileHandler;

    @Autowired
    private ProducerService producerService;

    @GetMapping
    public void readJson(){
        for(int i=0;i<100;i++){
            String employeeDetails= employeeFileHandler.readData(i);
            producerService.produceEmployeeDetails(employeeDetails);
        }
    }
}
