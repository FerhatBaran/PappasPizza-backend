package dat22v2.tb.pappaspizza.api;


import dat22v2.tb.pappaspizza.dto.*;
import dat22v2.tb.pappaspizza.service.IngredientService;
import dat22v2.tb.pappaspizza.service.OrderService;
import dat22v2.tb.pappaspizza.dto.DrinkResponse;
import dat22v2.tb.pappaspizza.dto.PizzaResponse;
import dat22v2.tb.pappaspizza.service.DrinkService;
import dat22v2.tb.pappaspizza.service.PizzaService;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/pizza")
public class PizzaController {


    PizzaService pizzaService;
    IngredientService ingredientService;
    OrderService orderService;

    DrinkService drinkService;


    public PizzaController(PizzaService pizzaService, IngredientService ingredientService, OrderService orderService) {
        this.pizzaService = pizzaService;
        this.ingredientService = ingredientService;
        this.orderService = orderService;
    }

    @GetMapping
    public List<PizzaResponse> getAllPizzas(){
        return pizzaService.getAllPizzas();
    }
    //Do the same as pizza
    //make it a Drink service
    //and drink response
    @GetMapping ("/drinks")
    public List<DrinkResponse> getDrinks(){
        return drinkService.getDrinks();
    }

    @GetMapping("/ingredients")
    public List<IngredientResponse> getAllIngredients(){
        return ingredientService.getAllIngredients();
    }



}
