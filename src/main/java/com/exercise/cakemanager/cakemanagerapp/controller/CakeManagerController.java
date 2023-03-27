package com.exercise.cakemanager.cakemanagerapp.controller;

import com.exercise.cakemanager.cakemanagerapp.entity.Cake;
import com.exercise.cakemanager.cakemanagerapp.service.CakeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CakeManagerController {

    private CakeService cakeService;

    public CakeManagerController(CakeService cakeService) {
        this.cakeService = cakeService;
    }

    @GetMapping("/cakes")
    public ResponseEntity<List<Cake>> getAllCakes() {

        return ResponseEntity.ok(cakeService.findAll());
    }

    @PostMapping("/cakes")
    public ResponseEntity<Cake> createCake(@RequestBody Cake cake) {
        cake.setID(0);
        return ResponseEntity.ok(cakeService.createOrUpdate(cake));
    }

    @PutMapping("/cakes")
    public ResponseEntity<Cake> updateCake(@RequestBody Cake cake) {

        return ResponseEntity.ok(cakeService.createOrUpdate(cake));
    }
    @DeleteMapping("/cakes/{id}")
    public ResponseEntity<String> deleteCake(@PathVariable int id) {
        Cake cake = cakeService.findById(id);
        if(cake == null) {
            return ResponseEntity.notFound().build();
        }
        cakeService.deleteCakeById(id);
        return ResponseEntity.ok("Success");
    }




}
