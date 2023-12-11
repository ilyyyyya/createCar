package com.example.createcar.config;

import com.example.createcar.model.CarBody;
import com.example.createcar.model.CarWheel;
import com.example.createcar.repository.CarBodyRepository;
import com.example.createcar.repository.CarWheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {


    private final CarBodyRepository carBodyRepository;
    private final CarWheelRepository carWheelRepository;

    @Autowired
    public DataInitializer(CarBodyRepository carBodyRepository, CarWheelRepository carWheelRepository) {
        this.carBodyRepository = carBodyRepository;
        this.carWheelRepository = carWheelRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // Инициализация данных для CarBody, если они отсутствуют в бд
        if (!carBodyRepository.existsById(1L)) {
            carBodyRepository.save(new CarBody("Hatchback"));
        }

        if (!carBodyRepository.existsById(2L)) {
            carBodyRepository.save(new CarBody("Sedan"));
        }

        int additionalQuantity = 15;

        // Инициализация данных для CarWheel, если отсутвуют в бд
        if (!carWheelRepository.existsById(1L)) {
            carWheelRepository.save(new CarWheel("R15", additionalQuantity));
        } else {
            CarWheel existingWheel = carWheelRepository.findById(1L).orElse(null);
            if (existingWheel != null) {
                // проверка на количество колес в наличии и последующее добавления этих колес в БД
                if(existingWheel.getAvailableQuantity() < 3){
                    existingWheel.setAvailableQuantity(existingWheel.getAvailableQuantity() + additionalQuantity);
                    carWheelRepository.save(existingWheel);
                }
            }
        }

        if (!carWheelRepository.existsById(2L)) {
            carWheelRepository.save(new CarWheel("R16", additionalQuantity));
        } else {
            CarWheel existingWheel = carWheelRepository.findById(2L).orElse(null);
            if (existingWheel != null) {
                if(existingWheel.getAvailableQuantity() < 3){
                    existingWheel.setAvailableQuantity(existingWheel.getAvailableQuantity() + additionalQuantity);
                    carWheelRepository.save(existingWheel);
                }
            }
        }

        if (!carWheelRepository.existsById(3L)) {
            carWheelRepository.save(new CarWheel("R17", additionalQuantity));
        } else {
            CarWheel existingWheel = carWheelRepository.findById(3L).orElse(null);
            if (existingWheel != null) {
                if(existingWheel.getAvailableQuantity() < 3){
                    existingWheel.setAvailableQuantity(existingWheel.getAvailableQuantity() + additionalQuantity);
                    carWheelRepository.save(existingWheel);
                }
            }
        }

    }
}
