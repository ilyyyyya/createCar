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

            //проверка на определенное количество колес в наличии
            if (carWheel.getAvailableQuantity() < 3) {

                //если не хватает, то добавляется еще 10 колес в БД
                carWheel.setAvailableQuantity(carWheel.getAvailableQuantity() + 10);
                carWheelRepository.save(carWheel);

            }
            //создание машины с определенными данными, который ввел пользователь
            if (carWheel.getAvailableQuantity() >= carRequest.getNumberOfWheels() && carRequest.getNumberOfWheels() == 4){

                //убирается из БД определенное кол-во колес
                carWheel.setAvailableQuantity(carWheel.getAvailableQuantity() - carRequest.getNumberOfWheels());

                Car car = new Car(carBody, carWheel, carRequest.getNumberOfWheels(), carRequest.getCoolName());
                return carRepository.save(car);
            } else {
                throw new IllegalArgumentException("Колес на машине должно быть строго 4 штуки.");
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
