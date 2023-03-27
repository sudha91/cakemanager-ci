package com.exercise.cakemanager.cakemanagerapp.service;

import com.exercise.cakemanager.cakemanagerapp.entity.Cake;
import jakarta.persistence.Id;

import java.util.List;

public interface CakeService {
    List<Cake> findAll();
    void save();
    Cake createOrUpdate(Cake cake);
    void deleteCakeById(int id);

    Cake findById(int id);

}
