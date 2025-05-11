package com.university.service;

import com.university.model.Degree;
import com.university.model.Department;
import com.university.model.Lector;
import com.university.repository.DepartmentRepository;
import com.university.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommandService {

    @Autowired
    private  DepartmentRepository departmentRepository;

    @Autowired
    private LectorRepository lectorRepository;

    public String getHeadOfDepartment(String departmentName) {
        Department department = departmentRepository.findByName(departmentName);
        if (department == null) { return "Department not found"; }
        String headFirstName = department.getHead().getFirstName();
        String headLastName = department.getHead().getLastName();
        return "Head of " + departmentName + " department is " + headLastName + " " + headFirstName;
    }


    public String getStatistics(String departmentName) {
        Department department = departmentRepository.findByName(departmentName);
        if (department == null) { return "Department not found"; }
        Map<Degree, Long> stats = department.getLectors().stream()
                .collect(Collectors.groupingBy(Lector::getDegree, Collectors.counting()));
        return "assistants - " + stats.getOrDefault(Degree.ASSISTANT, 0L) + "\n" +
                "associate professors - " + stats.getOrDefault(Degree.ASSOCIATE_PROFESSOR, 0L) + "\n" +
                "professors - " + stats.getOrDefault(Degree.PROFESSOR, 0L);
    }

    public String getAverageSalary(String departmentName) {
        Department department = departmentRepository.findByName(departmentName);
        if (department == null) { return "Department not found"; }
        Double averageSalary = department.getLectors().stream()
                .mapToDouble(Lector::getSalary).average().orElse(0.0);
        return "The average salary of " + departmentName + " is " + averageSalary;
    }

    public String getEmployeeCount(String departmentName) {
        Department department = departmentRepository.findByName(departmentName);
        if (department == null) { return "Department not found"; }
        return String.valueOf(department.getLectors().size());
    }

    public String globalSearch(String template) {
        List<String> results = new ArrayList<>();

        List<Lector> lectors = lectorRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(template, template);
        results.addAll(lectors.stream()
                .map(l -> l.getFirstName() + " " + l.getLastName())
                .toList());

        List<Department> departments = departmentRepository
                .findByNameContainingIgnoreCase(template);
        results.addAll(departments.stream()
                .map(Department::getName)
                .toList());

        if (results.isEmpty()) {
            return "No matches found for: " + template;
        }

        return String.join(", ", results);
    }


}
