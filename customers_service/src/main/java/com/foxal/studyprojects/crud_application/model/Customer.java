package com.foxal.studyprojects.crud_application.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "INN")
    private long inn;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
