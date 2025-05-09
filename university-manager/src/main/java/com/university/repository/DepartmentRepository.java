package com.university.repository;

import com.university.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Optional<Department> findByName(String name);
    List<Department> findByNameContainingIgnoreCase(String name);
}
