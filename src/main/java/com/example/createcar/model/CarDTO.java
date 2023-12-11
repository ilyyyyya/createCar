package com.example.createcar.model;

import lombok.Data;

@Data
public class CarDTO {
    private Long id;
    private String carBodyName;
    private String carWheelName;
    private int numberOfWheels;
    private String coolName;


    public CarDTO(Long id, String carBodyName, String carWheelName, int numberOfWheels, String coolName) {
        this.id = id;
        this.carBodyName = carBodyName;
        this.carWheelName = carWheelName;
        this.numberOfWheels = numberOfWheels;
        this.coolName = coolName;
    }
}
