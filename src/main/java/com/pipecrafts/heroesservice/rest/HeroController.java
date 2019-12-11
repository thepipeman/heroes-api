package com.pipecrafts.heroesservice.rest;

import com.pipecrafts.heroesservice.model.Hero;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/heroes")
public class HeroController {

   private List<Hero> someHeroes = List.of(
       new Hero(1L, "Ken"),
       new Hero(2L, "Yannick"),
       new Hero(3L, "Pieter"));

   @GetMapping
   public List<Hero> heroes() {
      return someHeroes;
   }

   @GetMapping("/{id}")
   public Hero hero(@PathVariable("id") String id) {
      return someHeroes.stream()
          .filter(h -> h.getId().toString().equals(id))
          .findFirst()
          .orElse(null);
   }

}
