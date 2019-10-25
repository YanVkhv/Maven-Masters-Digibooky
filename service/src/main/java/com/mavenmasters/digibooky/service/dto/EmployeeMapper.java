package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.users.employee.Admin;
import com.mavenmasters.digibooky.domain.users.employee.Employee;
import com.mavenmasters.digibooky.domain.users.employee.Librarian;

public class EmployeeMapper {

    public static Librarian createEmployeeDtoToLibrarian(CreateEmployeeDto createEmployeeDto) {
        return new Librarian(createEmployeeDto.getFirstName()
                , createEmployeeDto.getLastName()
                , createEmployeeDto.getEmail());
    }

    public static EmployeeDto employeeToEmployeeDto(Employee employee) {
        return new EmployeeDto().setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setEmail(employee.getEmail());
    }

    public static Admin createEmployeeDtoToAdmin(CreateEmployeeDto createEmployeeDto) {
        return new Admin(createEmployeeDto.getFirstName()
                , createEmployeeDto.getLastName()
                , createEmployeeDto.getEmail());
    }
}
