package com.example.createcar.repository;

import com.example.createcar.model.CarWheel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarWheelRepository extends JpaRepository<CarWheel, Long> {
}
