package dat22v2.tb.pappaspizza.api;


import dat22v2.tb.pappaspizza.dto.pizza.PizzaResponse;
import dat22v2.tb.pappaspizza.service.PizzaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pizzas")
@CrossOrigin
public class PizzaController {


    PizzaService pizzaService;


    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaResponse>> getAllPizzas(){
        return ResponseEntity.ok(pizzaService.getAllPizzas());
    }



}
