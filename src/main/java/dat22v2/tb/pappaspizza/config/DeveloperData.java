package dat22v2.tb.pappaspizza.config;


import dat22v2.tb.pappaspizza.entity.Drink;
import dat22v2.tb.pappaspizza.entity.Ingredient;
import dat22v2.tb.pappaspizza.entity.Pizza;
import dat22v2.tb.pappaspizza.repository.DrinkRepository;
import dat22v2.tb.pappaspizza.repository.IngredientRepository;
import dat22v2.tb.pappaspizza.repository.PizzaRepository;
import dat22v2.tb.pappaspizza.service.IngredientService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class DeveloperData implements ApplicationRunner {

  PizzaRepository pizzaRepository;
  DrinkRepository drinkRepository;
  IngredientRepository ingredientRepository;


  public DeveloperData(PizzaRepository pizzaRepository, DrinkRepository drinkRepository, IngredientRepository ingredientRepository, IngredientService ingredientService) {
    this.pizzaRepository = pizzaRepository;
    this.drinkRepository = drinkRepository;
    this.ingredientRepository = ingredientRepository;
  }

  public void pizzaList(){
    List<Pizza> pizzaList = new ArrayList<>();

    /*
    //ingredierne skal erstattes
    pizzaList.addAll(Arrays.asList(
        new Pizza(1, "Margherita", 68, List.of("Tomatsauce", "Ost")),
        new Pizza(2, "Vesuvio", 70, List.of("Tomatsauce", "Ost", "Skinke")),
        new Pizza(3, "Hawaii", 75, List.of("Tomatsauce", "Ost", "Skinke", "Ananas")),
        new Pizza(5, "Mix pizza", 85, List.of("Tomatsauce", "Ost", "Bacon", "Pepperoni", "Shawarma")),
        new Pizza(6, "Capricciosa", 75, List.of("Tomatsauce", "Ost", "Skinke", "Champignon")),
        new Pizza(7, "Denmark special", 85, List.of("Ost", "Skinke", "Bacon", "Pepperoni", "Løg")),
        new Pizza(8, "Napoli", 70, List.of("Tomatsauce", "Ost", "Pepperoni")),
        new Pizza(9, "Bolognese", 80, List.of("Tomatsauce", "Ost", "Kødsauce", "Løg")),
        new Pizza(10, "Kylling pizza", 80, List.of("Tomatsauce", "Ost", "Kylling", "Salat dressing", "Dressing")),
        new Pizza(11, "Romani", 85, List.of("Tomatsauce", "Ost", "Pepperoni", "Kødstrimler", "Gorgonzola")),
        new Pizza(12, "Orient", 85, List.of("Ost", "Champignon", "Shawarma", "Løg", "Kylling")),
        new Pizza(13, "Pappas", 85, List.of("Tomatsauce", "Ost", "Bacon", "Pepperoni", "æg")),
        new Pizza(14, "Vegetaria", 80, List.of("Tomatsauce", "Ost", "Ananas", "Champignon", "Løg", "Paprika", "Oliven")),
        new Pizza(15, "Feta", 80, List.of("Pepperoni", "Oliven", "Fetaost")),
        new Pizza(16, "Husets pizza", 80, List.of("Tomatsauce", "Ost", "Shawarma", "Salat dressing", "Dressing")),
        new Pizza(17, "Spinaci", 80, List.of("Tomatsauce", "Ost", "Gorgonzola", "Tomatskiver", "Spinat")),
        new Pizza(18, "Marmaris", 85, List.of("Tomatsauce", "Ost", "Champignon", "Løg", "Kødstrimler", "Paprika")),
        new Pizza(19, "Lezzet", 80, List.of("Tomatsauce", "Ost", "Ananas", "Pepperoni", "Oliven")),
        new Pizza(20, "Milano", 80, List.of("Tomatsauce", "Ost", "Kylling", "Paprika", "ærter", "Majs")),
        new Pizza(21, "Kebab", 80, List.of("Tomatsauce", "Ost", "Shawarma", "Løg", "Champginon", "Jalapenos")),
        new Pizza(22, "Memo speciale", 80, List.of("Tomatsauce", "Ost", "Hakket Kød", "Chili", "Grøn Peber")),
        new Pizza(23, "Tuna", 80, List.of("Tomatsauce", "Ost", "Champignon", "Løg", "Tun")),
        new Pizza(24, "Inca", 85, List.of("Tomatsauce", "Ost", "Pepperoni", "Jalapenos", "Hvidløg", "Hakket Oksekød", "Tacosauce")),
        new Pizza(26, "Matador", 85, List.of("Tomatsauce", "Ost", "Champignon", "Kødstrimler", "Stegt Løg", "Bearnaisesauce")),
        new Pizza(27, "Calzone (indbagt)", 75, List.of("Tomatsauce", "Ost")),
        new Pizza(28, "Firat (indbagt)", 85, List.of("Tomatsauce", "Ost", "Champignon", "Shawarma")),
        new Pizza(30, "Fatih", 85, List.of("Tomatsauce", "Ost", "Bacon", "Kylling", "Kartofler", "Rosmarin"))
    ));
*/
    pizzaList.addAll(Arrays.asList(
        new Pizza(1, "Margherita", 68, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"))),
        new Pizza(2, "Vesuvio", 70, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Skinke"))),
        new Pizza(3, "Hawaii", 75, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Skinke"), ingredientRepository.findIngredientByNameIgnoreCase("Ananas"))),
        new Pizza(5, "Mix pizza", 85, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Bacon"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Shawarma"))),
        new Pizza(6, "Capricciosa", 75, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Skinke"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"))),
        new Pizza(7, "Denmark special", 85, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Skinke"), ingredientRepository.findIngredientByNameIgnoreCase("Bacon"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"))),
        new Pizza(8, "Napoli", 70, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"))),
        new Pizza(9, "Bolognese", 80, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Kødsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"))),
        new Pizza(10, "Kylling pizza", 80, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Kylling"), ingredientRepository.findIngredientByNameIgnoreCase("Salat dressing"), ingredientRepository.findIngredientByNameIgnoreCase("Dressing"))),
        new Pizza(11, "Romani", 85, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Kødstrimler"), ingredientRepository.findIngredientByNameIgnoreCase("Gorgonzola"))),
        new Pizza(12, "Orient", 85, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Shawarma"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Kylling"))),
        new Pizza(13, "Pappas", 85, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Bacon"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("æg"))),
        new Pizza(14, "Vegetaria", 80, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Ananas"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Paprika"), ingredientRepository.findIngredientByNameIgnoreCase("Oliven"))),
        new Pizza(15, "Feta", 80, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Oliven"), ingredientRepository.findIngredientByNameIgnoreCase("Fetaost"))),
        new Pizza(16, "Husets pizza", 80, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Shawarma"), ingredientRepository.findIngredientByNameIgnoreCase("Salat dressing"), ingredientRepository.findIngredientByNameIgnoreCase("Dressing"))),
        new Pizza(17, "Spinaci", 80, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Gorgonzola"), ingredientRepository.findIngredientByNameIgnoreCase("Tomatskiver"), ingredientRepository.findIngredientByNameIgnoreCase("Spinat"))),
        new Pizza(18, "Marmaris", 85, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Kødstrimler"), ingredientRepository.findIngredientByNameIgnoreCase("Paprika"))),
        new Pizza(19, "Lezzet", 80, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Ananas"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Oliven"))),
        new Pizza(20, "Milano", 80, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Kylling"), ingredientRepository.findIngredientByNameIgnoreCase("Paprika"), ingredientRepository.findIngredientByNameIgnoreCase("ærter"), ingredientRepository.findIngredientByNameIgnoreCase("Majs"))),
        new Pizza(21, "Kebab", 80, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Shawarma"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Champginon"), ingredientRepository.findIngredientByNameIgnoreCase("Jalapenos"))),
        new Pizza(22, "Memo speciale", 80, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Hakket Kød"), ingredientRepository.findIngredientByNameIgnoreCase("Chili"), ingredientRepository.findIngredientByNameIgnoreCase("Grøn Peber"))),
        new Pizza(23, "Tuna", 80, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Tun"))),
        new Pizza(24, "Inca", 85, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Jalapenos"), ingredientRepository.findIngredientByNameIgnoreCase("Hvidløg"), ingredientRepository.findIngredientByNameIgnoreCase("Hakket Oksekød"), ingredientRepository.findIngredientByNameIgnoreCase("Tacosauce"))),
        new Pizza(26, "Matador", 85, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Kødstrimler"), ingredientRepository.findIngredientByNameIgnoreCase("Stegt Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Bearnaisesauce"))),
        new Pizza(27, "Calzone (indbagt)", 75, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"))),
        new Pizza(28, "Firat (indbagt)", 85, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Shawarma"))),
        new Pizza(30, "Fatih", 85, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Bacon"), ingredientRepository.findIngredientByNameIgnoreCase("Kylling"), ingredientRepository.findIngredientByNameIgnoreCase("Kartofler"), ingredientRepository.findIngredientByNameIgnoreCase("Rosmarin")))
    ));

    pizzaRepository.saveAll(pizzaList);
  }


  public void drinkList() {
    List<Drink> drinkList = new ArrayList<>();

    drinkList.addAll(Arrays.asList(
        new Drink("Coca Cola", "0.33L", 15, 1),
        new Drink("Coca Cola", "1.5L", 35, 2),
        new Drink("Coca-Cola Zero", "0.33L", 15, 3),
        new Drink("Coca-Cola Zero", "1.5L", 35, 4),
        new Drink("Faxe Kondi", "0.33L", 15, 5),
        new Drink("Faxe Kondi", "1.5L", 35, 6),
        new Drink("Kildevand", "", 15, 7),
        new Drink("Ayran", "0,33L", 15, 8),
        new Drink("Cocio", "0,33L", 25, 9)
    ));
    drinkRepository.saveAll(drinkList);
  }

  public void ingredientList(){
    List<Ingredient> ingredients = new ArrayList<>();

    Ingredient hvidlog = new Ingredient(1, "Hvidløg", 3.00);
    Ingredient chili = new Ingredient(2, "Chili", 4.00);
    Ingredient rosmarin = new Ingredient(3, "Rosmarin", 4.00);
    Ingredient aErter = new Ingredient(4, "ærter", 6.00);
    Ingredient majs = new Ingredient(5, "Majs", 6.00);
    Ingredient ananas = new Ingredient(6, "Ananas", 7.00);
    Ingredient aeg = new Ingredient(7, "æg", 7.00);
    Ingredient bearnaisesauce = new Ingredient(8, "Bearnaisesauce", 7.00);
    Ingredient champginon = new Ingredient(9, "Champginon", 7.00);
    Ingredient champignon = new Ingredient(10, "Champignon", 7.00);
    Ingredient dressing = new Ingredient(11, "Dressing", 7.00);
    Ingredient groenPeber = new Ingredient(12, "Grøn Peber", 7.00);
    Ingredient jalapenos = new Ingredient(13, "Jalapenos", 7.00);
    Ingredient kartofler = new Ingredient(14, "Kartofler", 7.00);
    Ingredient loeg = new Ingredient(15, "Løg", 7.00);
    Ingredient oliven = new Ingredient(16, "Oliven", 7.00);
    Ingredient paprika = new Ingredient(17, "Paprika", 7.00);
    Ingredient spinat = new Ingredient(18, "Spinat", 7.00);
    Ingredient stegtLoeg = new Ingredient(19, "Stegt Løg", 7.00);
    Ingredient tacosauce = new Ingredient(20, "Tacosauce", 7.00);
    Ingredient tomatsauce = new Ingredient(21, "Tomatsauce", 7.00);
    Ingredient tomatskiver = new Ingredient(22, "Tomatskiver", 7.00);
    Ingredient fetaost = new Ingredient(23, "Fetaost", 10.00);
    Ingredient hakketKoed = new Ingredient(24, "Hakket Kød", 10.00);
    Ingredient hakketOksekod = new Ingredient(25, "Hakket Oksekød", 10.00);
    Ingredient kylling = new Ingredient(26, "Kylling", 10.00);
    Ingredient ost = new Ingredient(27, "Ost", 10.00);
    Ingredient pepperoni = new Ingredient(28, "Pepperoni", 10.00);
    Ingredient shawarma = new Ingredient(29, "Shawarma", 10.00);
    Ingredient skinke = new Ingredient(30, "Skinke", 10.00);
    Ingredient spaghetti = new Ingredient(31, "Spaghetti", 10.00);
    Ingredient bacon = new Ingredient(32, "Bacon", 13.00);
    Ingredient gorgonzola = new Ingredient(33, "Gorgonzola", 13.00);
    Ingredient koedsauce = new Ingredient(34, "Kødsauce", 13.00);
    Ingredient koedstrimler = new Ingredient(35, "Kødstrimler", 13.00);
    Ingredient rejer = new Ingredient(36, "Rejer", 13.00);
    Ingredient salatdressing = new Ingredient(37, "Salat dressing", 13.00);
    Ingredient tun = new Ingredient(38, "Tun", 13.00);

    ingredients.add(hvidlog);
    ingredients.add(chili);
    ingredients.add(rosmarin);
    ingredients.add(aErter);
    ingredients.add(majs);
    ingredients.add(ananas);
    ingredients.add(aeg);
    ingredients.add(bearnaisesauce);
    ingredients.add(champginon);
    ingredients.add(champignon);
    ingredients.add(dressing);
    ingredients.add(groenPeber);
    ingredients.add(jalapenos);
    ingredients.add(kartofler);
    ingredients.add(loeg);
    ingredients.add(oliven);
    ingredients.add(paprika);
    ingredients.add(spinat);
    ingredients.add(stegtLoeg);
    ingredients.add(tacosauce);
    ingredients.add(tomatsauce);
    ingredients.add(tomatskiver);
    ingredients.add(fetaost);
    ingredients.add(hakketKoed);
    ingredients.add(hakketOksekod);
    ingredients.add(kylling);
    ingredients.add(ost);
    ingredients.add(pepperoni);
    ingredients.add(shawarma);
    ingredients.add(skinke);
    ingredients.add(spaghetti);
    ingredients.add(bacon);
    ingredients.add(gorgonzola);
    ingredients.add(koedsauce);
    ingredients.add(koedstrimler);
    ingredients.add(rejer);
    ingredients.add(salatdressing);
    ingredients.add(tun);

    ingredientRepository.saveAll(ingredients);


  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    ingredientList();
    pizzaList();
    drinkList();
  }
}
