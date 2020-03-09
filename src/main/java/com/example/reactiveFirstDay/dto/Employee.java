package com.example.reactiveFirstDay.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Employee implements Serializable {

  private static final long serialVersionUID = 1546351419026865663L;
  private int id;
  private String name;
  private int age;
  private String department;
}
