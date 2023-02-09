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

    @GetMapping("all")
    public ResponseEntity<List<Recipes>> getAllRecipes() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    /*
    GET individual Car sing ID
     */
    // @GetMapping("{id}")
    // public recipes getRecipes(Long id) {
    //     return new recipes("", "", "");
    // }
    // public ResponseEntity<Recipes> getRecipe(@PathVariable long id) {
    //     return new ResponseEntity<>(repository.getRecipes(id), HttpStatus.OK);
    // }
    @GetMapping("{id}") 
    public Recipes getRecipe(long id) {
        return (repository.findById(id).isPresent())
                ? repository.findById(id).get()
                : null;
    }
    /*
    DELETE individual Car using ID
     */
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deleteRecipes(@PathVariable long id) {
        repository.deleteById(id);
        return new ResponseEntity<>( ""+ id +" deleted", HttpStatus.OK);
    }

    public void saveRecipes(Recipes recipes) {
        repository.save(recipes);
    }
    /*
    POST Aa record by Requesting Parameters from URI
     */
    @PostMapping( "/post/")
    public ResponseEntity<Object> postRecipes(@RequestParam("name") String name, @RequestParam("ingredients") String ingredients,
                                             @RequestParam("description") String description) {

        saveRecipes(new Recipes(null, name, ingredients, description));
        return new ResponseEntity<>(name +" is created successfully", HttpStatus.CREATED);
    }


}