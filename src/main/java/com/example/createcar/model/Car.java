package com.example.createcar.model;

import jakarta.persistence.*;
import lombok.*;

import javax.management.ConstructorParameters;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_body_id")
    private CarBody carBody;

    @ManyToOne
    @JoinColumn(name = "car_wheels_id")
    private CarWheel carWheel;

    @Column(name = "number0fWheels")
    private int numberOfWheels;

    @Column(name = "coolName")
    private String coolName;


    public Car( CarBody carBody, CarWheel carWheel, int numberOfWheels, String coolName) {
        this.carBody = carBody;
        this.carWheel = carWheel;
        this.numberOfWheels = numberOfWheels;
        this.coolName = coolName;
    }
}
