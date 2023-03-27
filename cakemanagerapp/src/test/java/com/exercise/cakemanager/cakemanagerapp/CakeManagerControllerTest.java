package com.exercise.cakemanager.cakemanagerapp;

import com.exercise.cakemanager.cakemanagerapp.controller.CakeManagerController;
import com.exercise.cakemanager.cakemanagerapp.entity.Cake;
import com.exercise.cakemanager.cakemanagerapp.service.CakeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CakeManagerControllerTest {

    @InjectMocks
    CakeManagerController cakeController;

    @Mock
    CakeService cakeService;


    @Test
    public void testAddCake() {
        Cake cake = new Cake(1, "CarrotCake", "Bugs bunnys favourite",
                "http://www.villageinn.com/i/pies/profile/carrotcake_main1.jpg");
        when(cakeService.createOrUpdate(any(Cake.class))).thenReturn(cake);
        ResponseEntity<Cake> newCake = cakeController.createCake(cake);
        assertThat(newCake.getStatusCode().is2xxSuccessful());
        assertEquals(newCake.getBody().getDesc(), "Bugs bunnys favourite");
        assertNotEquals(1, newCake.getBody().getID() );
    }

    @Test
    public void testFindAll() {
        Cake cake1 = new Cake(1, "CarrotCake", "Bugs bunnys favourite",
                "http://www.villageinn.com/i/pies/profile/carrotcake_main1.jpg");
        Cake cake2 = new Cake(2, "CarrotCake2", "Bugs bunnys favourite",
                "http://www.villageinn.com/i/pies/profile/carrotcake_main1.jpg");
        List<Cake> cakes = new ArrayList<>();
        cakes.add(cake1);
        cakes.add(cake2);
        when(cakeService.findAll()).thenReturn(cakes);
        ResponseEntity<List<Cake>> result =cakeController.getAllCakes();
        assertThat(result.getBody().size()).isEqualTo(2);
        assertThat(result.getBody().get(0).getTitle()).isEqualTo("CarrotCake");
    }

    @Test
    public void testDeleteCake() {
        Cake cake = new Cake(1, "CarrotCake", "Bugs bunnys favourite",
                "http://www.villageinn.com/i/pies/profile/carrotcake_main1.jpg");
        when(cakeService.findById(1)).thenReturn(cake);

        ResponseEntity<String> result = cakeController.deleteCake(1);
        assertThat(result.getBody()).isEqualTo("Success");

    }

    @Test
    public void testDeleteCakeNotExists()  {
        Cake cake = null;
        when(cakeService.findById(2)).thenReturn(cake);
        ResponseEntity<String> result = cakeController.deleteCake(2);
        assertThat(result.getStatusCode().is4xxClientError());
    }

    @Test
    public void testUpdateCake() {
        Cake cake = new Cake(3, "CarrotCake3", "Bugs bunnys favourite",
                "http://www.villageinn.com/i/pies/profile/carrotcake_main1.jpg");
        when(cakeService.createOrUpdate(any(Cake.class))).thenReturn(cake);
        ResponseEntity<Cake> newCake = cakeController.updateCake(cake);
        assertThat(newCake.getStatusCode().is2xxSuccessful());
        assertEquals(newCake.getBody().getDesc(), "Bugs bunnys favourite");
        assertEquals(3, newCake.getBody().getID() );

    }

    @Test
    public void testFindAllNoneExists() {
        List<Cake> cakes = new ArrayList<>();
        when(cakeService.findAll()).thenReturn(cakes);
        ResponseEntity<List<Cake>> result = cakeController.getAllCakes();
        assertThat(result.getBody().size()).isEqualTo(0);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
      