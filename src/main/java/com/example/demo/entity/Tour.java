package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "tours")
public class Tour implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "sportId", nullable = false)
    private int sportId;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "startTime", nullable = false)
    private Timestamp startTime;

    @Column(name = "endTime", nullable = false)
    private Timestamp endTime;

    @Column(name = "recUpdatedAt", nullable = false)
    private Timestamp recUpdatedAt;

    @Column(name = "createdAt", nullable = false, updatable = false)
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sportId", referencedColumnName = "id", insertable = false, updatable = false)
    private Sport sport;

    // Constructors, getters, and setters

    public Tour() {
    }

    public Tour(String name, int sportId, boolean status, Timestamp startTime, Timestamp endTime) {
        this.name = name;
        this.sportId = sportId;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and setters

    // Omitted getter and setter for sport

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

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getRecUpdatedAt() {
        return recUpdatedAt;
    }

    public void setRecUpdatedAt(Timestamp recUpdatedAt) {
        this.recUpdatedAt = recUpdatedAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
