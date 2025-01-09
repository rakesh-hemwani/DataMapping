package com.whitewolfs.rakesh.project.DataMappings.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@Builder
@Getter
@Setter
@AllArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "manager")
    @JsonIgnore
    private DepartmentEntity managedDepartment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "worker_department_id", referencedColumnName = "id")
    @JsonIgnore
    private DepartmentEntity workerDepartment;

    @ManyToMany
    @JoinTable(name = "freelance_department_mapping",
                joinColumns = @JoinColumn(name = "employee_id"),
                inverseJoinColumns = @JoinColumn(name = "department_id"))
    @JsonIgnore
    private Set<DepartmentEntity> freelanceDepartment;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
