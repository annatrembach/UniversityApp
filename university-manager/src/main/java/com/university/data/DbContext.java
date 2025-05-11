package com.university.data;

import com.university.model.Degree;
import com.university.model.Department;
import com.university.model.Lector;
import com.university.repository.DepartmentRepository;
import com.university.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class DbContext {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private LectorRepository lectorRepository;

    public void initTestData() {
        if (departmentRepository.count() > 0) {
            return;
        }

        Lector l1 = new Lector("Ivan", "Petrenko", 6000.0, Degree.PROFESSOR);
        Lector l2 = new Lector("Olena", "Shevchenko", 3000.0, Degree.ASSISTANT);
        Lector l3 = new Lector("Andrii", "Ivanov", 4500.0, Degree.ASSOCIATE_PROFESSOR);
        Lector l4 = new Lector("Maria", "Bondarenko", 6200.0, Degree.PROFESSOR);
        Lector l5 = new Lector("Petro", "Vasylenko", 2800.0, Degree.ASSISTANT);

        lectorRepository.saveAll(List.of(l1, l2, l3, l4, l5));

        Department math = new Department("Mathematics");
        Department physics = new Department("Physics");
        Department cs = new Department("Computer Science");

        departmentRepository.saveAll(List.of(math, physics, cs));

        l1.setDepartments(Set.of(math, cs));
        l2.setDepartments(Set.of(physics));
        l3.setDepartments(Set.of(math, physics));
        l4.setDepartments(Set.of(physics));
        l5.setDepartments(Set.of(cs));

        math.setHead(l1);
        physics.setHead(l3);
        cs.setHead(l2);

        lectorRepository.saveAll(List.of(l1, l2, l3, l4, l5));
        departmentRepository.saveAll(List.of(math, physics, cs));
    }
}
