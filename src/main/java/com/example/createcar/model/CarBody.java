package com.example.createcar.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "car_bodies")
@Data
@NoArgsConstructor

public class CarBody {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "type")
    private String type;

    public CarBody(String type) {
        this.type = type;
    }
}
