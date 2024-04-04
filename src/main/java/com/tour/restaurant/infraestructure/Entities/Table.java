package com.restaurant.main.infraestructure.Entities;
import jakarta.persistence.*;

@Entity
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_table")
    private Long idTable;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "number")
    private int number;

    @Column(name = "available")
    private boolean available;

    @Column(name = "restaurant_id")
    private Long restaurantId;

    @OneToOne(mappedBy = "table", fetch = FetchType.LAZY)
    private Booking booking;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;



    public Long getIdTable() {
        return idTable;
    }

    public void setIdTable(Long id) {
        this.idTable = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
