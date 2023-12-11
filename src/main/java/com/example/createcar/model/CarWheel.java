package com.example.createcar.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car_wheels")
@NoArgsConstructor
@Data
public class CarWheel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "size")
    private String size;

    @Column(name = "quantity")
    private int availableQuantity;

    public CarWheel(String size, int availableQuantity) {
        this.size = size;
        this.availableQuantity = availableQuantity;
    }

}
