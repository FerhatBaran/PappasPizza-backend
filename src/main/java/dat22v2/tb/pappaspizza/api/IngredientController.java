package dat22v2.tb.pappaspizza.api;

import dat22v2.tb.pappaspizza.dto.IngredientRequest;
import dat22v2.tb.pappaspizza.dto.IngredientResponse;
import dat22v2.tb.pappaspizza.exception.IlegalIngredientException;
import dat22v2.tb.pappaspizza.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/ingredients")
public class IngredientController {

    IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @GetMapping()
    public List<IngredientResponse> getAllIngredients(){
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/{id}")
    public IngredientResponse getSpecificIngredient(@PathVariable Integer id){
        return ingredientService.getSpecificIngredient(id);
    }


    @PostMapping()
    public IngredientResponse addIngredient (@RequestBody IngredientRequest body) throws IlegalIngredientException {
        return ingredientService.addIngredient(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity editIngredient(@PathVariable Integer id, @RequestBody IngredientRequest body){
        ingredientService.editIngredient(id,body);
        return ResponseEntity.ok(true);
    }


    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Integer id){
        ingredientService.deleteIngredient(id);
    }


}