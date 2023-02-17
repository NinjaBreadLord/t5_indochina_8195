package com.nighthawk.spring_portfolio.mvc.recipes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nighthawk.spring_portfolio.mvc.recipes.recipesJpaRepository;
import com.nighthawk.spring_portfolio.mvc.recipes.recipes;

import java.util.*;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/recipes")
public class recipesAPIController {

    @Autowired
    recipesJpaRepository repository;

    @GetMapping("/all")
    public ResponseEntity<List<recipes>> getAllRecipes() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") 
    public recipes getRecipe(Long id) {
        return (repository.findById(id).isPresent())
                ? repository.findById(id).get()
                : null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteRecipes(@PathVariable Long id) {
        repository.deleteById(id);  
        return new ResponseEntity<>( ""+ id +" deleted", HttpStatus.OK);
    }

    public void saveRecipes(recipes recipes) {
        repository.save(recipes);
    }

    @PostMapping( "/post/")
    public ResponseEntity<Object> postRecipes(@RequestParam("name") String name, @RequestParam("ingredients") String ingredients,
                                             @RequestParam("description") String description, @RequestParam("region") String region, @RequestParam("preparation") int preparation) {

        saveRecipes(new recipes(null, name, ingredients, description, region, preparation));
        return new ResponseEntity<>(name +" is created successfully", HttpStatus.CREATED);
    }
    
}