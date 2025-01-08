package com.whitewolfs.rakesh.project.DataMappings.controllers;

import com.whitewolfs.rakesh.project.DataMappings.entities.DepartmentEntity;
import com.whitewolfs.rakesh.project.DataMappings.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @GetMapping("{departmentId}")
    public DepartmentEntity getDepartmentById(@PathVariable Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity departmentEntity){
        return departmentService.createNewDepartment(departmentEntity);
    }

    @PutMapping("assign/{departmentId}/manager/{employeeId}")
    public DepartmentEntity assignManagerToDepartment(@PathVariable Long departmentId,
                                                      @PathVariable Long employeeId){
        return departmentService.assignManagerToDepartment(departmentId, employeeId);
    }

    @GetMapping("assignedDepartmentOfManger/{employeeId}")
    public DepartmentEntity getAssignDepartmentOfManager(@PathVariable Long employeeId){
        return departmentService.getAssignDepartmentOfManager(employeeId);
    }

}
