package com.exercise.cakemanager.cakemanagerapp.dao;

import com.exercise.cakemanager.cakemanagerapp.entity.Cake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CakeRepository extends JpaRepository<Cake, Integer> {
}
