package br.com.pizzaria.trainee.pizza;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component

public class PizzaRepositoryImpl implements PizzaRepository {

    Set<Pizza> pizzas = new HashSet<>();

    @Override
    public Pizza save(Pizza pizza){
        pizzas.add(pizza);
        return pizza;
    }

    public Set<Pizza> findAll() { return pizzas;}

    @Override
    public Pizza findOne(UUID id){
        for (Pizza pizza: pizzas) {
            if(pizza.getId().equals(id)){
                return pizza;
            }
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        Pizza pizza = this.findOne(id);
        this.pizzas.remove(pizza);

    }

}
