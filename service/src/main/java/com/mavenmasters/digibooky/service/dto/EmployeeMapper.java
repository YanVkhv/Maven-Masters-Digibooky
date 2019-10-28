package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.users.employee.Admin;
import com.mavenmasters.digibooky.domain.users.employee.Employee;
import com.mavenmasters.digibooky.domain.users.employee.Librarian;
import com.mavenmasters.digibooky.domain.users.member.Email;

public class EmployeeMapper {

    public static Librarian createEmployeeDtoToLibrarian(CreateEmployeeDto createEmployeeDto) {
        return new Librarian(createEmployeeDto.getFirstName()
                , createEmployeeDto.getLastName()
                , new Email(createEmployeeDto.getEmail()));
    }

    public static EmployeeDto employeeToEmployeeDto(Employee employee) {
        return new EmployeeDto().setId(employee.getId())
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setEmail(employee.getEmail());
    }

    public static Admin createEmployeeDtoToAdmin(CreateEmployeeDto createEmployeeDto) {
        return new Admin(createEmployeeDto.getFirstName()
                , createEmployeeDto.getLastName()
                , new Email(createEmployeeDto.getEmail()));
    }
}
