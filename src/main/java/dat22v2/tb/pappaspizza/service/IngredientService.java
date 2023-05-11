package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.dto.ingredient.IngredientResponse;
import dat22v2.tb.pappaspizza.entity.Ingredient;
import dat22v2.tb.pappaspizza.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }


    public List<IngredientResponse> getAllIngredients() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        List<IngredientResponse> ingredientResponses;
        ingredientResponses = ingredients.stream().map(ingredient -> new IngredientResponse(ingredient)).toList();
        return ingredientResponses;
    }

    public Ingredient findIngredientByName(String name) {
        return ingredientRepository.findIngredientByNameIgnoreCase(name);
    }

}
