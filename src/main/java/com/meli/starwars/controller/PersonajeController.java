package com.meli.starwars.controller;

import com.meli.starwars.service.PersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class PersonajeController {

    private PersonajeService personajeService;

    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }
    @GetMapping("/personaje/{name}")
    public ResponseEntity getNombre(@PathVariable() String name){
        List<String> lista = personajeService.getNombres(name);
        return new ResponseEntity(lista, HttpStatus.OK);
    }
}
