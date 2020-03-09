package com.example.reactiveFirstDay.service;

import com.example.reactiveFirstDay.dto.Employee;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

  public Mono<Employee> getEmployeeById(int id) {
    return Mono.just(Employee.builder().id(id).name("ramesh").age(30).department("java").build());
  }

  public Flux<Employee> getEmployees() {
    Employee ramesh = Employee.builder().id(1001).name("ramesh").age(30).department("java").build();
    Employee suresh = Employee.builder().id(1002).name("suresh").age(30).department("java").build();
    return Flux.just(ramesh, suresh);
  }
}
