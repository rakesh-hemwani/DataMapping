package com.whitewolfs.rakesh.project.DataMappings.services;

import com.whitewolfs.rakesh.project.DataMappings.entities.DepartmentEntity;
import com.whitewolfs.rakesh.project.DataMappings.entities.EmployeeEntity;
import com.whitewolfs.rakesh.project.DataMappings.repositories.DepartmentRepository;
import com.whitewolfs.rakesh.project.DataMappings.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity employeeEntity){
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }


}
