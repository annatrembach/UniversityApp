package com.university.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @OneToOne
    @JoinColumn(name = "head_id")
    private Lector head;

    @ManyToMany(mappedBy = "departments")
    private List<Lector> lectors;

    // constructors

    public Department(String name, Lector head, List<Lector> lectors) {
        this.name = name;
        this.head = head;
        this.lectors = lectors;
    }

    public Department() {
    }

    // getters and setters

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lector getHead() {
        return head;
    }

    public void setHead(Lector head) {
        this.head = head;
    }

    public List<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(List<Lector> lectors) {
        this.lectors = lectors;
    }

    // equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(Id, that.Id) && Objects.equals(name, that.name) && Objects.equals(head, that.head) && Objects.equals(lectors, that.lectors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, head, lectors);
    }
}
