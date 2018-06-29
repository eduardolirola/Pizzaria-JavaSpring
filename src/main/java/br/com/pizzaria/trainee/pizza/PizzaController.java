package br.com.pizzaria.trainee.pizza;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("api/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping
    public ResponseEntity criar(Pizza pizza) {
        Pizza pizzaCriado = this.pizzaService.criar(pizza);
        return new ResponseEntity(
                pizzaCriado
                        .toString(),
                HttpStatus.CREATED);
    }

    @GetMapping
    public Set<Pizza> listar() { return this.pizzaService.listar();}

    @GetMapping ("/findby")
    public Pizza obter(@RequestParam("id")UUID id) {
        return this.pizzaService.obter(id);
    }

    @PutMapping
    public ResponseEntity editar(
            @RequestParam("id")UUID id,
            @RequestBody Pizza pizza) {
        this.pizzaService.editar(id, pizza);
        return new ResponseEntity("Editado com sucesso",HttpStatus.OK);

    }




}

