package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.repository.PizzaRepository;
import org.springframework.stereotype.Service;


@Service
public class PizzaService {

    PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }



}
