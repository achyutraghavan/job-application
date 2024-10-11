package com.achyutraghavan.job_application.job;

//import jakarta.persistence.Entity; // tells entity is mapped to class
//import jakarta.persistence.GeneratedValue; // to allow jpa manage what type of values are generated
//import jakarta.persistence.Id; // to rename table name, by default it's the name of the entity
//import jakarta.persistence.Table; // to set primary key
// import jakarta.persistence.GenerationType;

import jakarta.persistence.*;

@Entity
@Table(name="job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    public Job() {  // default constructor required by jpa
    }

    public Job(Long id, String title, String minSalary, String description, String maxSalary, String location) {
        this.id = id;
        this.title = title;
        this.minSalary = minSalary;
        this.description = description;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
