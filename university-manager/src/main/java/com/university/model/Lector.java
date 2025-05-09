package com.university.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private Double Salary;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @OneToOne(mappedBy = "head", fetch = FetchType.EAGER)
    private Department headOf;

    @ManyToMany
    @JoinTable(
            name = "department_lector",
            joinColumns = @JoinColumn(name = "lector_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private Set<Department> departments = new HashSet<>();

    // constructors

    public Lector(String firstName, String lastName, Double salary, Degree degree, Department headOf, Set<Department> departments) {
        this.firstName = firstName;
        this.lastName = lastName;
        Salary = salary;
        this.degree = degree;
        this.headOf = headOf;
        this.departments = departments;
    }

    public Lector() {
    }

    // getters and setters

    public Long getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Department getHeadOf() {
        return headOf;
    }

    public void setHeadOf(Department headOf) {
        this.headOf = headOf;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    // equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lector lector = (Lector) o;
        return Objects.equals(Id, lector.Id) && Objects.equals(firstName, lector.firstName) && Objects.equals(lastName, lector.lastName) && Objects.equals(Salary, lector.Salary) && degree == lector.degree && Objects.equals(headOf, lector.headOf) && Objects.equals(departments, lector.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstName, lastName, Salary, degree, headOf, departments);
    }
}
