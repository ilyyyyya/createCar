package com.example.createcar.repository;

import com.example.createcar.model.CarBody;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarBodyRepository extends JpaRepository<CarBody, Long> {
}
