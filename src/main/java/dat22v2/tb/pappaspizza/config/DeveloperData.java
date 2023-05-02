package dat22v2.tb.pappaspizza.config;


import dat22v2.tb.pappaspizza.entity.Drink;
import dat22v2.tb.pappaspizza.entity.Pizza;
import dat22v2.tb.pappaspizza.repository.DrinkRepository;
import dat22v2.tb.pappaspizza.repository.PizzaRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

  public DeveloperData(PizzaRepository pizzaRepository, DrinkRepository drinkRepository) {
    this.pizzaRepository = pizzaRepository;
    this.drinkRepository = drinkRepository;
  }

  public void pizzaList(){
    List<Pizza> pizzaList = new ArrayList<>();

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

  @Override
  public void run(ApplicationArguments args) throws Exception {
pizzaList();
drinkList();
  }
}
