package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.config.DeveloperData;
import dat22v2.tb.pappaspizza.dto.PizzaResponse;
import dat22v2.tb.pappaspizza.entity.Pizza;
import dat22v2.tb.pappaspizza.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PizzaService {

    PizzaRepository pizzaRepository;
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaResponse> getPizzas(){
        return pizzaRepository.findAll().stream().map(PizzaResponse::new).toList();
    }
}
