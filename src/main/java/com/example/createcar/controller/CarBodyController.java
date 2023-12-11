package com.example.createcar.controller;

import com.example.createcar.model.CarBody;
import com.example.createcar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/car-bodies")
public class CarBodyController {

    @Autowired
    private CarService carService;

    @GetMapping("/getAllCarBody")
    public ResponseEntity<List<CarBody>> getAllCarBody() {
        List<CarBody> carBodies = carService.getAllCarBody();
        return ResponseEntity.ok(carBodies);
    }
}
