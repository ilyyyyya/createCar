package com.example.createcar.service;

import com.example.createcar.model.*;
import com.example.createcar.repository.CarBodyRepository;
import com.example.createcar.repository.CarRepository;
import com.example.createcar.repository.CarWheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarWheelRepository carWheelRepository;
    @Autowired
    private CarBodyRepository carBodyRepository;
    @Autowired
    private CarRepository carRepository;


    public List<CarBody> getAllCarBody() {
        return carBodyRepository.findAll();
    }

    public List<CarWheel> getAllCarWheels() {
        return carWheelRepository.findAll();
    }


    public Car createCar(CarRequest carRequest) {
        CarBody carBody = carBodyRepository.findById(carRequest.getCarBodyId()).orElse(null);
        CarWheel carWheel = carWheelRepository.findById(carRequest.getCarWheelId()).orElse(null);

        if (carBody != null && carWheel != null) {

            if (carWheel.getAvailableQuantity() < 2) {

                carWheel.setAvailableQuantity(carWheel.getAvailableQuantity() + 10);
                carWheelRepository.save(carWheel);

            }

            if (carWheel.getAvailableQuantity() >= carRequest.getNumberOfWheels()) {

                carWheel.setAvailableQuantity(carWheel.getAvailableQuantity() - carRequest.getNumberOfWheels());

                Car car = new Car(carBody, carWheel, carRequest.getNumberOfWheels(), carRequest.getCoolName());
                return carRepository.save(car);
            } else {
                throw new IllegalArgumentException("Недостаточно колес нужного размера.");
            }
        } else {
                throw new IllegalArgumentException("Корпус или колесо с заданным ID не найдено.");
        }
    }

    public List<CarDTO> getCars(){

        List<Car> cars = carRepository.findAll();

        List<CarDTO> carDTOS = new ArrayList<>();

        for(Car car : cars) {
            carDTOS.add(new CarDTO(
                    car.getId(),
                    car.getCarBody().getType(),
                    car.getCarWheel().getSize(),
                    car.getNumberOfWheels(),
                    car.getCoolName()
            ));
        }
        return carDTOS;
    }

    public CarDTO getCarByID(Long id) {

        Car car = carRepository.findById(id).orElse(null);

        if (car != null) {
            return new CarDTO(
                    car.getId(),
                    car.getCarBody().getType(),
                    car.getCarWheel().getSize(),
                    car.getNumberOfWheels(),
                    car.getCoolName()
            );
        } else {
            return null;
        }
    }



}
