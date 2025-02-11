package com.travel.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @ManyToOne//多対一
    @JoinColumn(name = "user_id" , nullable = false)
    private User user ;

    @ManyToOne
    @JoinColumn(name = "travel_plan_id" , nullable = false)
    private TravelPlan travelPlan ;

    @Column(nullable = false)//同じ日程で別の旅行はできない
    private LocalDate reserved_date ;

    @Column(name = "payment_status" ,nullable = false)//支払いは未完了か完了しかない
    private String paymentStatus ;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TravelPlan getTravelPlan() {
        return travelPlan;
    }

    public void setTravelPlan(TravelPlan travelPlan) {
        this.travelPlan = travelPlan;
    }

    public LocalDate getReservedDate() {
        return reserved_date;
    }

    public void setReservedDate(LocalDate reservedDate) {
        this.reserved_date = reservedDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
