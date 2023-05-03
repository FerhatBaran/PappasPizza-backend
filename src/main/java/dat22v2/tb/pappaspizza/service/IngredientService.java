package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.entity.Ingredient;
import dat22v2.tb.pappaspizza.repository.IngredientRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

  IngredientRepository ingredientRepository;

  public IngredientService(IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  public Ingredient findIngredientByName(String name) {
    return ingredientRepository.findIngredientByNameIgnoreCase(name);
  }

}
