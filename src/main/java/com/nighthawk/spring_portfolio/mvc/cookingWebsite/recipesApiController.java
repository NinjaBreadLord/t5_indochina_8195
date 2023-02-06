package com.nighthawk.spring_portfolio.mvc.cookingWebsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inversoft.chef.domain.Recipes;
import com.microsoft.azure.cognitiveservices.search.imagesearch.models.Recipe;
import com.nighthawk.spring_portfolio.mvc.cookingWebsite.recipesJPARepository;

import java.util.*;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/recipes/")
public class recipesApiController {

    @Autowired
    recipesJPARepository repository;

    @GetMapping("all")
    public ResponseEntity<List<Recipes>> getAllRecipes() {
        return new ResponseEntity<>(repository.findAllByOrderByNameAsc(), HttpStatus.OK);
    }

    /*
     * GET individual Car using ID
     */
    @GetMapping("{id}")
    public ResponseEntity<Recipes> getRecipes(@PathVariable long id) {
        return new ResponseEntity<>(repository.getRecipe(id), HttpStatus.OK);
    }

    /*
     * DELETE individual Car using ID
     */
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deleteRecipes(@PathVariable long id) {
        repository.deleteRecipe(id);
        return new ResponseEntity<>("" + id + " deleted", HttpStatus.OK);
    }

    /*
     * POST Aa record by Requesting Parameters from URI
     */
    @PostMapping("/post/")
    public ResponseEntity<Object> postPerson(@RequestParam("name") String name,
            @RequestParam("ingredients") String ingredients,
            @RequestParam("description") String description) {

        repository.saveRecipe(new Recipe(null, name, ingredients, description));
        return new ResponseEntity<>(name + " is created successfully", HttpStatus.CREATED);
    }

}