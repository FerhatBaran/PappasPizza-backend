package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.dto.pizza.PizzaRequest;
import dat22v2.tb.pappaspizza.dto.pizza.PizzaResponse;
import dat22v2.tb.pappaspizza.entity.Ingredient;
import dat22v2.tb.pappaspizza.entity.Pizza;
import dat22v2.tb.pappaspizza.repository.IngredientRepository;
import dat22v2.tb.pappaspizza.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PizzaService {

    PizzaRepository pizzaRepository;

    IngredientRepository ingredientRepository;

    public PizzaService(PizzaRepository pizzaRepository, IngredientRepository ingredientRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<PizzaResponse> getAllPizzas() {
        List<Pizza> pizzas = pizzaRepository.findAll();
        List<PizzaResponse> pizzaResponses = new ArrayList<>();
        pizzaResponses = pizzas.stream().map(pizza -> new PizzaResponse(pizza)).toList();
        System.out.println(pizzaResponses);
        return pizzaResponses;
    }

    public List<PizzaResponse> getPizzas(){
        return pizzaRepository.findAll().stream().map(PizzaResponse::new).toList();
    }

    public PizzaResponse addPizza(PizzaRequest pizzaRequest) {
        Pizza pizza = PizzaRequest.getPizzaEntity(pizzaRequest);

        List<String> namesOfIngredients = pizza.getIngredients().stream().map(Ingredient::getName).toList();

        pizza.setIngredients(ingredientRepository.findByNameIn(namesOfIngredients));

        return new PizzaResponse(pizzaRepository.save(pizza));
    }
}
