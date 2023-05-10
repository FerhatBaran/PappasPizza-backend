package dat22v2.tb.pappaspizza.config;

import dat22v2.tb.pappaspizza.entity.*;
import dat22v2.tb.pappaspizza.repository.*;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class DeveloperData implements ApplicationRunner {

    IngredientRepository ingredientRepository;
    OrderRepository orderRepository;
    PizzaRepository pizzaRepository;
    DrinkRepository drinkRepository;
    ReceiptRepository receiptRepository;

    PizzaTypeRepository pizzaTypeRepository;

    public DeveloperData(IngredientRepository ingredientRepository, OrderRepository orderRepository, PizzaRepository pizzaRepository, DrinkRepository drinkRepository, ReceiptRepository receiptRepository, PizzaTypeRepository pizzaTypeRepository) {
        this.ingredientRepository = ingredientRepository;
        this.orderRepository = orderRepository;
        this.pizzaRepository = pizzaRepository;
        this.drinkRepository = drinkRepository;
        this.receiptRepository = receiptRepository;
        this.pizzaTypeRepository = pizzaTypeRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        ingredientList();
        pizzaTypes();
        pizzaList();




    }



    public void pizzaList(){

        Pizza pizza1 = Pizza.builder()
            .name("Pizza1")
            .pizzaType(pizzaTypeRepository.findById(1).orElseThrow(() -> new EntityNotFoundException("OOF")))
            .build();
        pizza1.setPrice(69);
        pizza1.addIngredient(ingredientRepository.findById(6).orElseThrow( () ->  new EntityNotFoundException("ingen ingrediens")));
        pizza1.addIngredient(ingredientRepository.findById(12).orElseThrow( () ->  new EntityNotFoundException("ingen ingrediens")));
        pizza1.addIngredient(ingredientRepository.findById(13).orElseThrow( () ->  new EntityNotFoundException("ingen ingrediens")));
        pizzaRepository.save(pizza1);

        Pizza pizza2 = Pizza.builder()
            .name("Pizza2")
            .pizzaType(pizzaTypeRepository.findById(2).orElseThrow(() -> new EntityNotFoundException("OOF")))
            .build();
        pizza2.setPrice(79);
        pizza2.addIngredient(ingredientRepository.findById(4).orElseThrow( () ->  new EntityNotFoundException("ingen ingrediens")));
        pizza2.addIngredient(ingredientRepository.findById(5).orElseThrow( () ->  new EntityNotFoundException("ingen ingrediens")));
        pizza2.addIngredient(ingredientRepository.findById(19).orElseThrow( () ->  new EntityNotFoundException("ingen ingrediens")));
        pizzaRepository.save(pizza2);



    }


    public void drinkList() {
        List<Drink> drinkList = new ArrayList<>();




        drinkRepository.saveAll(drinkList);
    }

    public void pizzaTypes() {
        pizzaTypeRepository.save(PizzaType.builder().size("ALM").price(0.0).build());
        pizzaTypeRepository.save(PizzaType.builder().size("FAM").price(90.0).build());
    }

    public void ingredientList(){
        List<Ingredient> ingredients = new ArrayList<>();

        ingredients.add(new Ingredient(1, "Hvidløg", 3.00));
        ingredients.add(new Ingredient(2, "Chili", 4.00));
        ingredients.add(new Ingredient(3, "Rosmarin", 4.00));
        ingredients.add(new Ingredient(4, "ærter", 6.00));
        ingredients.add(new Ingredient(5, "Majs", 6.00));
        ingredients.add(new Ingredient(6, "Ananas", 7.00));
        ingredients.add(new Ingredient(7, "æg", 7.00));
        ingredients.add(new Ingredient(8, "Bearnaisesauce", 7.00));
        ingredients.add(new Ingredient(9, "Champginon", 7.00));
        ingredients.add(new Ingredient(10, "Champignon", 7.00));
        ingredients.add(new Ingredient(11, "Dressing", 7.00));
        ingredients.add(new Ingredient(12, "Grøn Peber", 7.00));
        ingredients.add(new Ingredient(13, "Jalapenos", 7.00));
        ingredients.add(new Ingredient(14, "Kartofler", 7.00));
        ingredients.add(new Ingredient(15, "Løg", 7.00));
        ingredients.add(new Ingredient(16, "Oliven", 7.00));
        ingredients.add(new Ingredient(17, "Paprika", 7.00));
        ingredients.add(new Ingredient(18, "Spinat", 7.00));
        ingredients.add(new Ingredient(19, "Stegt Løg", 7.00));
        ingredients.add(new Ingredient(20, "Tacosauce", 7.00));
        ingredients.add(new Ingredient(21, "Tomatsauce", 7.00));
        ingredients.add(new Ingredient(22, "Tomatskiver", 7.00));
        ingredients.add(new Ingredient(23, "Fetaost", 10.00));
        ingredients.add(new Ingredient(24, "Hakket Kød", 10.00));
        ingredients.add(new Ingredient(25, "Hakket Oksekød", 10.00));
        ingredients.add(new Ingredient(26, "Kylling", 10.00));
        ingredients.add(new Ingredient(27, "Ost", 10.00));
        ingredients.add(new Ingredient(28, "Pepperoni", 10.00));
        ingredients.add(new Ingredient(29, "Shawarma", 10.00));
        ingredients.add(new Ingredient(30, "Skinke", 10.00));
        ingredients.add(new Ingredient(31, "Spaghetti", 10.00));
        ingredients.add(new Ingredient(32, "Bacon", 13.00));
        ingredients.add(new Ingredient(33, "Gorgonzola", 13.00));
        ingredients.add(new Ingredient(34, "Kødsauce", 13.00));
        ingredients.add(new Ingredient(35, "Kødstrimler", 13.00));
        ingredients.add(new Ingredient(36, "Rejer", 13.00));
        ingredients.add(new Ingredient(37, "Salat dressing", 13.00));
        ingredients.add(new Ingredient(38, "Tun", 13.00));


        ingredientRepository.saveAll(ingredients);


    }
}
