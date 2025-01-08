package com.whitewolfs.rakesh.project.DataMappings.repositories;

import com.whitewolfs.rakesh.project.DataMappings.entities.DepartmentEntity;
import com.whitewolfs.rakesh.project.DataMappings.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    DepartmentEntity findByManager(EmployeeEntity employeeEntity);
}
