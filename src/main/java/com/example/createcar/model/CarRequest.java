package com.example.createcar.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CarRequest {
    private Long carBodyId;
    private Long carWheelId;
    private int numberOfWheels;
    private String coolName;

    public CarRequest(Long carBodyId, Long carWheelId, int numberOfWheels, String coolName) {
        this.carBodyId = carBodyId;
        this.carWheelId = carWheelId;
        this.numberOfWheels = numberOfWheels;
        this.coolName = coolName;
    }


}
