package br.com.pizzaria.trainee.pizza;

import java.util.Set;
import java.util.UUID;

public interface PizzaService {
    Pizza criar (Pizza pizza);

    Set<Pizza> listar();

    Pizza obter(UUID id);

    void editar (UUID id, Pizza pizza);


}
