package com.SPbootCRUD.CRUDoperations.controller;

import com.SPbootCRUD.CRUDoperations.dto.EmployeeDto;
import com.SPbootCRUD.CRUDoperations.model.Employee;
import com.SPbootCRUD.CRUDoperations.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.time.LocalTime;
import java.util.List;




@RestController //capable to handle hhtp request
@RequestMapping("employee")
public class EmployeeController {
    @Autowired private final EmployeeService employeeService;

    // Constructor injection for EmployeeService
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //Read
    @RequestMapping (value = "/get", method=RequestMethod.GET)
    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees() ;
    }


    //ADD
//    @Scheduled(cron = "*/30,*,*,*,*,*")

    @RequestMapping(value = "/add", method=RequestMethod.POST)
    public String addEmployees(@RequestBody EmployeeDto employeeDto)
    {

        System.out.println(LocalTime.now()+"    "+"Adding after 30 secs");
        return employeeService.addEmployee(employeeDto) ;
    }

    //Edit
    @RequestMapping(value = "/edit", method=RequestMethod.PUT)
    public String editEmployees(@RequestBody EmployeeDto employeeDto)
    {

        return employeeService.editEmployee(employeeDto) ;
    }

    //delete
    @DeleteMapping("/dell/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
    }

    //scheduled addfunction
    @Scheduled(fixedDelay = 30000) // Run every 30 seconds
    public void scheduleAddEmployees() {
        EmployeeDto employeeDto = new EmployeeDto();
        // Set the necessary properties of employeeDto

        System.out.println(LocalTime.now() + " Adding after 30 secs");
        employeeService.addEmployee(employeeDto);
    }

}
