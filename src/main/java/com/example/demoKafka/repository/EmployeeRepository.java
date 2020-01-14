package com.example.demoKafka.repository;

import com.example.demoKafka.document.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,String>
{

}
