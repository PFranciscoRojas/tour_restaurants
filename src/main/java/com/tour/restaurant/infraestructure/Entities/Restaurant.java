package com.restaurant.main.infraestructure.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restaurant")
    private Long idRestaurant;

    @Column(name = "name")
    private String name;

    @Column(name = "adrees")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "plan")
    private String plan;


    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    private List<Table> tables;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Long id) {
        this.idRestaurant = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
}
