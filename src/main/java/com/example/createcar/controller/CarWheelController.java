package com.example.createcar.controller;

import com.example.createcar.model.CarWheel;
import com.example.createcar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/car-wheels")
public class CarWheelController {

    @Autowired
    private CarService carService;

    @GetMapping("/getAllCarWheels")
    public ResponseEntity<List<CarWheel>> getAllCarWheels() {
        List<CarWheel> carWheels = carService.getAllCarWheels();
        return ResponseEntity.ok(carWheels);
    }
}
