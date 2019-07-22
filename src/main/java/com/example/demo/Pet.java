package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private int age;

    private String animal;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, fetch=FetchType.EAGER)

    public Set<People> people;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public Set<People> getPeople() {
        return people;
    }

    public void setPeople(Set<People> people) {
        this.people = people;
    }
}
