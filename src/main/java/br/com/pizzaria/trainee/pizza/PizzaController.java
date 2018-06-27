package br.com.pizzaria.trainee.pizza;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("api/pizzaria")
public class PizzaController {

    @Autowired
    private PizzaService pizzaservice;

    @PostMapping
    public ResponseEntity criar(RequestBody Pizza pizza) {
        Pizza pizzaCriado = this.pizzaservice.criar(pizza);
        return new ResponseEntity(
                pizzaCriado
                        .toString(),
                HttpStatus.CREATED);
    }

    GetMapping
    public Set<Pizza> listar() { return this.pizzaservice.listar();}

    @GetMapping ("/findby")
    public Pizza obter(@RequestParam("id")UUID id) {
        return this.pizzaservice.obter(id);
    }

    @PutMapping
    public ResponseEntity editar(
            @RequestParam("id")UUID id,
            @RequestBody Pizza pizza) {
        this.pizzaservice.editar((id, pizza);
        return new ResponseEntity("Editado com sucesso",HttpStatus.OK);

    }




}

