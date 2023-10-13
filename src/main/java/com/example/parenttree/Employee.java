package com.example.parenttree;

import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private List<Employee> subordinates;

    public Employee(String name) {
        this.name = name;
        this.subordinates = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }
}

