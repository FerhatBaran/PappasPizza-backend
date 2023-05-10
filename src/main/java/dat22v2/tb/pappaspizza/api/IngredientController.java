package dat22v2.tb.pappaspizza.api;


import dat22v2.tb.pappaspizza.dto.IngredientResponse;
import dat22v2.tb.pappaspizza.service.IngredientService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
@CrossOrigin
public class IngredientController {

    IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    private ResponseEntity<List<IngredientResponse>> getIngredients() {
        return ResponseEntity.ok(ingredientService.getAllIngredients());
    }




}
