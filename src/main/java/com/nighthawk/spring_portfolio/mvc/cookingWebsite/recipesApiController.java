package com.nighthawk.spring_portfolio.mvc.cookingWebsite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microsoft.azure.cognitiveservices.search.imagesearch.models.Recipe;
import com.nighthawk.spring_portfolio.mvc.cookingWebsite.recipesJPARepository;
import com.nighthawk.spring_portfolio.mvc.cookingWebsite.Recipes;

import java.util.*;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/recipes/")
public class recipesApiController {

    @Autowired
    recipesJPARepository repository;

    @GetMapping("/all")
    public ResponseEntity<List<Recipes>> getAllRecipes() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") 
    public Recipes getRecipe(Long id) {
        return (repository.findById(id).isPresent())
                ? repository.findById(id).get()
                : null;
    }

    /*
     * DELETE individual Car using ID
     */
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deleteRecipes(@PathVariable Long id) {
        repository.deleteById(id);  
        return new ResponseEntity<>( ""+ id +" deleted", HttpStatus.OK);
    }

    public void saveRecipes(Recipes recipes) {
        repository.save(recipes);
    }

    @PostMapping( "/post/")
    public ResponseEntity<Object> postRecipes(@RequestParam("name") String name, @RequestParam("ingredients") String ingredients,
                                             @RequestParam("description") String description) {

        saveRecipes(new Recipes(null, name, ingredients, description));
        return new ResponseEntity<>(name +" is created successfully", HttpStatus.CREATED);
    }

     
    @GetMapping( "/country/")
    public ResponseEntity<Object> tagRecipes(@RequestParam("country") String country) {
                return (repository.findByCountry(country).isPresent())
                ? repository.findByCountry(country).get()
                : null;
    }
    

}

