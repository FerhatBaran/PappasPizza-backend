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

    public DeveloperData(IngredientRepository ingredientRepository, OrderRepository orderRepository, PizzaRepository pizzaRepository, DrinkRepository drinkRepository, ReceiptRepository receiptRepository) {
        this.ingredientRepository = ingredientRepository;
        this.orderRepository = orderRepository;
        this.pizzaRepository = pizzaRepository;
        this.drinkRepository = drinkRepository;
        this.receiptRepository = receiptRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        //Ingredients.

        Ingredient cheese = new Ingredient();
        cheese.setName("Cheese");
        cheese.setPrice(2.00);

        Ingredient tomatoSauce = new Ingredient();
        tomatoSauce.setName("Tomato Sauce");
        tomatoSauce.setPrice(1.00);

        Ingredient pepperoni = new Ingredient();
        pepperoni.setName("Pepperoni");
        pepperoni.setPrice(3.00);

        Ingredient mushrooms = new Ingredient();
        mushrooms.setName("Mushrooms");
        mushrooms.setPrice(2.00);

        Ingredient olives = new Ingredient();
        olives.setName("Olives");
        olives.setPrice(1.00);

        Ingredient onions = new Ingredient();
        onions.setName("Onions");
        onions.setPrice(1.00);

        Ingredient bacon = new Ingredient();
        bacon.setName("Bacon");
        bacon.setPrice(3.00);

        Ingredient sausage = new Ingredient();
        sausage.setName("Sausage");
        sausage.setPrice(3.00);

        Ingredient greenPeppers = new Ingredient();
        greenPeppers.setName("Green Peppers");
        greenPeppers.setPrice(1.00);

        Ingredient ham = new Ingredient();
        ham.setName("Ham");
        ham.setPrice(3.00);

        Ingredient pineapple = new Ingredient();
        pineapple.setName("Pineapple");
        pineapple.setPrice(2.00);

        ingredientRepository.save(cheese);
        ingredientRepository.save(tomatoSauce);
        ingredientRepository.save(pepperoni);
        ingredientRepository.save(mushrooms);
        ingredientRepository.save(olives);
        ingredientRepository.save(onions);
        ingredientRepository.save(bacon);
        ingredientRepository.save(sausage);
        ingredientRepository.save(greenPeppers);
        ingredientRepository.save(ham);
        ingredientRepository.save(pineapple);
        /*
        * */

        //Pizza

        Pizza margherita = new Pizza();
        margherita.setName("Margherita");
        margherita.setPrice(10.0);
        margherita.addIngredient(ingredientRepository.findById(1).orElseThrow(() -> new EntityNotFoundException("pubad")));
        margherita.addIngredient(ingredientRepository.findById(2).orElseThrow(() -> new EntityNotFoundException("pubad")));

        pizzaRepository.save(margherita);

        Pizza pepperoniPizza = new Pizza();
        pepperoniPizza.setName("Napoli");
        pepperoniPizza.setPrice(12.0);
        pepperoniPizza.addIngredient(ingredientRepository.findById(1).orElseThrow(() -> new EntityNotFoundException("pubad")));
        pepperoniPizza.addIngredient(ingredientRepository.findById(2).orElseThrow(() -> new EntityNotFoundException("pubad")));
        pepperoniPizza.addIngredient(ingredientRepository.findById(3).orElseThrow(() -> new EntityNotFoundException("pubad")));

        pizzaRepository.save(pepperoniPizza);

        Pizza hawaiian = new Pizza();
        hawaiian.setName("Hawaiian");
        hawaiian.setPrice(12.0);
        hawaiian.addIngredient(ingredientRepository.findById(1).orElseThrow(() -> new EntityNotFoundException("pubad")));
        hawaiian.addIngredient(ingredientRepository.findById(2).orElseThrow(() -> new EntityNotFoundException("pubad")));
        hawaiian.addIngredient(ingredientRepository.findById(10).orElseThrow(() -> new EntityNotFoundException("pubad")));
        hawaiian.addIngredient(ingredientRepository.findById(11).orElseThrow(() -> new EntityNotFoundException("pubad")));
        pizzaRepository.save(hawaiian);

        Pizza custom = new Pizza();
        custom.setId(80);
        custom.setName("Custom Pizza");
        custom.setPrice(10.0);
        custom.addIngredient(ingredientRepository.findById(1).orElseThrow(() -> new EntityNotFoundException("pubad")));
        custom.addIngredient(ingredientRepository.findById(2).orElseThrow(() -> new EntityNotFoundException("pubad")));

        pizzaRepository.save(custom);

        //Orders


        Order order1 = Order.builder().phoneNumber("12345678")
            .name("bob")
            .creationDate(LocalDateTime.now())
            .address("test")
            .postalCode(2000)
            .pickUpTime(LocalDateTime.of(2020,10,23,5,5,5))
            .confirmed(false)
            .status(OrderStatus.FRESH)
            .build();


        order1.addPizza(pizzaRepository.findById(1));
        order1.addPizza(pizzaRepository.findById(2));
        orderRepository.save(order1);


        Order order2 = Order.builder().phoneNumber("87654321")
            .name("lise")
            .address("test2")
            .creationDate(LocalDateTime.now())
            .postalCode(2000)
            .pickUpTime(LocalDateTime.of(2020,10,23,5,5,5))
            .confirmed(true)
            .status(OrderStatus.IN_PROGRESS)
            .build();


        order2.addPizza(pizzaRepository.findById(3));
        order2.addPizza(pizzaRepository.findById(4));
        orderRepository.save(order2);


        Receipt receipt = new Receipt();

        receipt.setOrder(order2);

        receiptRepository.save(receipt);





    }



    public void pizzaList(){
        List<Pizza> pizzaList = new ArrayList<>();


        pizzaList.addAll(Arrays.asList(
            new Pizza(1, "Margherita", 68.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"))),
            new Pizza(2, "Vesuvio", 70.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Skinke"))),
            new Pizza(3, "Hawaii", 75.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Skinke"), ingredientRepository.findIngredientByNameIgnoreCase("Ananas"))),
            new Pizza(5, "Mix pizza", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Bacon"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Shawarma"))),
            new Pizza(6, "Capricciosa", 75.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Skinke"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"))),
            new Pizza(7, "Denmark special", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Skinke"), ingredientRepository.findIngredientByNameIgnoreCase("Bacon"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"))),
            new Pizza(8, "Napoli", 70.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"))),
            new Pizza(9, "Bolognese", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Kødsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"))),
            new Pizza(10, "Kylling pizza", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Kylling"), ingredientRepository.findIngredientByNameIgnoreCase("Salat dressing"), ingredientRepository.findIngredientByNameIgnoreCase("Dressing"))),
            new Pizza(11, "Romani", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Kødstrimler"), ingredientRepository.findIngredientByNameIgnoreCase("Gorgonzola"))),
            new Pizza(12, "Orient", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Shawarma"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Kylling"))),
            new Pizza(13, "Pappas", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Bacon"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("æg"))),
            new Pizza(14, "Vegetaria", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Ananas"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Paprika"), ingredientRepository.findIngredientByNameIgnoreCase("Oliven"))),
            new Pizza(15, "Feta", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Oliven"), ingredientRepository.findIngredientByNameIgnoreCase("Fetaost"))),
            new Pizza(16, "Husets pizza", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Shawarma"), ingredientRepository.findIngredientByNameIgnoreCase("Salat dressing"), ingredientRepository.findIngredientByNameIgnoreCase("Dressing"))),
            new Pizza(17, "Spinaci", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Gorgonzola"), ingredientRepository.findIngredientByNameIgnoreCase("Tomatskiver"), ingredientRepository.findIngredientByNameIgnoreCase("Spinat"))),
            new Pizza(18, "Marmaris", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Kødstrimler"), ingredientRepository.findIngredientByNameIgnoreCase("Paprika"))),
            new Pizza(19, "Lezzet", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Ananas"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Oliven"))),
            new Pizza(20, "Milano", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Kylling"), ingredientRepository.findIngredientByNameIgnoreCase("Paprika"), ingredientRepository.findIngredientByNameIgnoreCase("ærter"), ingredientRepository.findIngredientByNameIgnoreCase("Majs"))),
            new Pizza(21, "Kebab", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Shawarma"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Champginon"), ingredientRepository.findIngredientByNameIgnoreCase("Jalapenos"))),
            new Pizza(22, "Memo speciale", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Hakket Kød"), ingredientRepository.findIngredientByNameIgnoreCase("Chili"), ingredientRepository.findIngredientByNameIgnoreCase("Grøn Peber"))),
            new Pizza(23, "Tuna", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Tun"))),
            new Pizza(24, "Inca", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Jalapenos"), ingredientRepository.findIngredientByNameIgnoreCase("Hvidløg"), ingredientRepository.findIngredientByNameIgnoreCase("Hakket Oksekød"), ingredientRepository.findIngredientByNameIgnoreCase("Tacosauce"))),
            new Pizza(26, "Matador", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Kødstrimler"), ingredientRepository.findIngredientByNameIgnoreCase("Stegt Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Bearnaisesauce"))),
            new Pizza(27, "Calzone (indbagt)", 75.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"))),
            new Pizza(28, "Firat (indbagt)", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Shawarma"))),
            new Pizza(30, "Fatih", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Bacon"), ingredientRepository.findIngredientByNameIgnoreCase("Kylling"), ingredientRepository.findIngredientByNameIgnoreCase("Kartofler"), ingredientRepository.findIngredientByNameIgnoreCase("Rosmarin")))
        ));

        pizzaRepository.saveAll(pizzaList);
    }


    public void drinkList() {
        List<Drink> drinkList = new ArrayList<>();

        drinkList.addAll(Arrays.asList(
            new Drink(1,"Coca Cola", "0.33L", 15.0),
            new Drink(2,"Coca Cola", "1.5L", 35.0),
            new Drink(3,"Coca-Cola Zero", "0.33L", 15.0),
            new Drink(4,"Coca-Cola Zero", "1.5L", 35.0),
            new Drink(5,"Faxe Kondi", "0.33L", 15.0),
            new Drink(6,"Faxe Kondi", "1.5L", 35.0),
            new Drink(7,"Kildevand", "", 15.0),
            new Drink(8,"Ayran", "0,33L", 15.0),
            new Drink(9,"Cocio", "0,33L", 25.0)
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
}
