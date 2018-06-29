package br.com.pizzaria.trainee.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service

public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository repository;

    @Override
    public Pizza criar(Pizza pizza) {
        return this.repository.save(pizza);
    }

    @Override
    public Set<Pizza> listar() {
        return this.repository.findAll();
    }

    @Override
    public Pizza obter(UUID id){
        return this.repository.findOne(id);
    }

    @Override
    public void remover(UUID id) {
        this.repository.delete(id);
    }

    @Override
    public void editar(UUID id,Pizza pizza) {
        Pizza pizzaRecuperado = this.obter(id);
        remover(id);
        pizzaRecuperado.setMassa(pizza.getMassa());
        pizzaRecuperado.setMolho(pizza.getMolho());
        pizzaRecuperado.setQueijo(pizza.getQueijo());
        pizzaRecuperado.setSabor(pizza.getSabor());
        pizzaRecuperado.setTempoDePreparo(pizza.getTempoDePreparo());

        this.repository.save(pizzaRecuperado);

    }

}
