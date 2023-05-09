package dat22v2.tb.pappaspizza.api;


import dat22v2.tb.pappaspizza.dto.*;
import dat22v2.tb.pappaspizza.repository.OrderRepository;
import dat22v2.tb.pappaspizza.service.IngredientService;
import dat22v2.tb.pappaspizza.service.OrderService;
import dat22v2.tb.pappaspizza.service.PizzaService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/pizza")
public class PizzaController {


    PizzaService pizzaService;
    IngredientService ingredientService;
    OrderService orderService;

    public PizzaController(PizzaService pizzaService, IngredientService ingredientService, OrderService orderService) {
        this.pizzaService = pizzaService;
        this.ingredientService = ingredientService;
        this.orderService = orderService;
    }

    @GetMapping
    public List<PizzaResponse> getAllPizzas(){
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/ingredients")
    public List<IngredientResponse> getAllIngredients(){
        return ingredientService.getAllIngredients();
    }



}
