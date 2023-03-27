package com.exercise.cakemanager.cakemanagerapp.service;

import com.exercise.cakemanager.cakemanagerapp.dao.CakeRepository;
import com.exercise.cakemanager.cakemanagerapp.entity.Cake;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Service
public class CakeServiceImpl implements CakeService {
    private CakeRepository cakeRepo;

    @Autowired
    public CakeServiceImpl(CakeRepository cakeRepo) {
        this.cakeRepo = cakeRepo;
    }

    @Override
    public List<Cake> findAll() {
        return cakeRepo.findAll();
    }

    @Override
    public void save() {
        try {
            List<Cake> cakes = get("https://gist.githubusercontent.com/hart88/198f29ec5114a3ec3460/raw/8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/cake.json");
            for (Cake cake : cakes) {
                cakeRepo.save(cake);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Cake> get(String url) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new URL(url), new TypeReference<List<Cake>>() {});
    }

    @Override
    public Cake createOrUpdate(Cake cake) {
        return cakeRepo.save(cake);
    }

    @Override
    public void deleteCakeById(int id) {
        cakeRepo.deleteById(id);
    }

    public Cake findById(int id) {
        Cake cake = null;
        Optional<Cake> result = cakeRepo.findById(id);
        if (result.isPresent()) {
            cake = result.get();
        }
        return cake;
    }
}
