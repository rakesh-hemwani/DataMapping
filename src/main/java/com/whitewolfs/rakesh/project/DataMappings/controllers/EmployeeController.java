package com.whitewolfs.rakesh.project.DataMappings.controllers;

import com.whitewolfs.rakesh.project.DataMappings.entities.DepartmentEntity;
import com.whitewolfs.rakesh.project.DataMappings.entities.EmployeeEntity;
import com.whitewolfs.rakesh.project.DataMappings.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.createNewEmployee(employeeEntity);
    }


}
