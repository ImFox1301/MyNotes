package com.foxal.studyprojects.crud_application.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    public Customer(){

    }
    public Customer(String name, long inn) {
        this.name = name;
        this.inn = inn;
    }

    private int id;
    private String name;
    private long inn;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "INN", nullable = false, unique = true)
    public long getInn() {
        return inn;
    }

    public void setInn(long inn) {
        this.inn = inn;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inn=" + inn +
                '}';
    }
}
