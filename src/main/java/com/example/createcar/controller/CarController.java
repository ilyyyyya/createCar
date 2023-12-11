package com.example.createcar.controller;

import com.example.createcar.model.Car;
import com.example.createcar.model.CarDTO;
import com.example.createcar.model.CarRequest;
import com.example.createcar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/createCar")
    public ResponseEntity<?> createCar(@RequestBody CarRequest carRequest) {

        try {
            Car createdCar = carService.createCar(carRequest);
            return ResponseEntity.ok(createdCar);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/getCars")
    public ResponseEntity<?> getCars(){
        List<CarDTO> cars = carService.getCars();
        return ResponseEntity.ok(cars);
    }


    @GetMapping("/getCarById/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable Long id){
        CarDTO car = carService.getCarByID(id);
        return ResponseEntity.ok(car);
    }




}
