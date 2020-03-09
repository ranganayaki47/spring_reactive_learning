package com.example.reactiveFirstDay.controllers;

import com.example.reactiveFirstDay.dto.Employee;
import com.example.reactiveFirstDay.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Mono<Employee> sayHelloWorld(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("generate/error")
    public Mono sayHelloWorld1(){
        return Mono.error(new Exception("some exception"));
    }

    @GetMapping(value="/",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Employee> sayHelloWorld2(){
        return employeeService.getEmployees().delayElements(Duration.ofSeconds(1));
    }
}
