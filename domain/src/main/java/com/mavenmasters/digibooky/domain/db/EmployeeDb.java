package com.mavenmasters.digibooky.domain.db;

import com.mavenmasters.digibooky.domain.users.employee.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EmployeeDb implements Database<UUID, Employee> {

    private HashMap<UUID, Employee> employees = new HashMap<>();


    @Override
    public Map<UUID, Employee> getAll() {
        return employees;
    }

    @Override
    public Employee getById(UUID id) {
        return employees.get(id);
    }

    public Employee addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
        return employee;
    }
}
