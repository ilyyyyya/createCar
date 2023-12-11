package com.example.createcar;

import com.example.createcar.model.CarBody;
import com.example.createcar.model.CarWheel;
import com.example.createcar.repository.CarBodyRepository;
import com.example.createcar.repository.CarWheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CreateCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreateCarApplication.class, args);
    }

}

