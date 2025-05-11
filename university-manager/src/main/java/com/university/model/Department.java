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

    @ManyToMany(mappedBy = "departments", fetch = FetchType.EAGER)
    private List<Lector> lectors;

    public Department(String name) {
        this.name = name;
    }

    public Department() {
    }

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


}
