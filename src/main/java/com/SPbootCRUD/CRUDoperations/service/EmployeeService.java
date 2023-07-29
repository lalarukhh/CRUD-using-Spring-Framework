package com.SPbootCRUD.CRUDoperations.service;

import com.SPbootCRUD.CRUDoperations.dto.EmployeeDto;
import com.SPbootCRUD.CRUDoperations.model.Employee;
import com.SPbootCRUD.CRUDoperations.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    //Read Operation
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }
    //Add Operation
    public String addEmployee(EmployeeDto employeeDto)
    {
//        List<Employee> list = getAllEmployees();
//        if(list.contains(employeeDto.getEmail()))
//        {
//            return "This Email Already Exits! Try with new one.";
//        }
//        else
        if(checkUnique(employeeDto.getEmail()))
        {

            Employee employee = new Employee();
            employee.setEmail(employeeDto.getEmail());
            employee.setName(employeeDto.getName());
            employeeRepository.save(employee);
            return "Employee Added!";
        }
        return "This Email Already Exits! Try with new one.";
    }
    //Edit Operation
    public String editEmployee(EmployeeDto employeeDto)
    {
        Employee employee = employeeRepository.getById(employeeDto.getId()) ;
        employee.setEmail(employeeDto.getEmail());
        employee.setName(employeeDto.getName());
        employeeRepository.save(employee);
        return "Edited Successfully!";
    }
    //Delete Operation
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public boolean checkUnique(String email){
        List<Employee> list = getAllEmployees();
        boolean exists = list.stream()
                .anyMatch(element -> element.getEmail().equals(email));

        if (exists) {
            return false;
        }
            return true;
        }

    }

