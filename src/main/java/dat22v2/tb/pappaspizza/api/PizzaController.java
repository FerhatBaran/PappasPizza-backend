package dat22v2.tb.pappaspizza.api;


import dat22v2.tb.pappaspizza.config.DeveloperData;
import dat22v2.tb.pappaspizza.dto.DrinkResponse;
import dat22v2.tb.pappaspizza.dto.PizzaResponse;
import dat22v2.tb.pappaspizza.entity.Drink;
import dat22v2.tb.pappaspizza.entity.Pizza;
import dat22v2.tb.pappaspizza.service.DrinkService;
import dat22v2.tb.pappaspizza.service.PizzaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/pizza")
public class PizzaController {


    DeveloperData developerData;
    PizzaService pizzaService;

    DrinkService drinkService;


    public PizzaController(PizzaService pizzaService, DrinkService drinkService) {
        this.pizzaService = pizzaService;
        this.drinkService = drinkService;
    }

    @GetMapping ("/pizzas")
    public List<PizzaResponse> getPizzas(){
        return pizzaService.getPizzas();
    }

    //Do the same as pizza
    //make it a Drink service
    //and drink response
    @GetMapping ("/drinks")
    public List<DrinkResponse> getDrinks(){
        return drinkService.getDrinks();
    }




}
