package com.mavenmasters.digibooky.service;

import com.mavenmasters.digibooky.domain.db.EmployeeDb;
import com.mavenmasters.digibooky.domain.users.employee.Admin;
import com.mavenmasters.digibooky.domain.users.member.Email;
import com.mavenmasters.digibooky.service.dto.CreateEmployeeDto;
import com.mavenmasters.digibooky.service.dto.EmployeeDto;
import com.mavenmasters.digibooky.service.dto.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final EmployeeDb employees;

    @Autowired
    public AdminService() {
        this.employees = new EmployeeDb();
        employees.addEmployee(new Admin("Admin", "Admin", new Email("admin@digibooky.be")));
    }

    public EmployeeDto registerNewLibrarian(CreateEmployeeDto createEmployeeDto) {
        return EmployeeMapper.employeeToEmployeeDto(
                employees.addEmployee(
                        EmployeeMapper.createEmployeeDtoToLibrarian(createEmployeeDto)));
    }

    public EmployeeDto registerNewAdmin(CreateEmployeeDto createEmployeeDto) {
        return EmployeeMapper.employeeToEmployeeDto(
                employees.addEmployee(
                        EmployeeMapper.createEmployeeDtoToAdmin(createEmployeeDto)));
    }

}
