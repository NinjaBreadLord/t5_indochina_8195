package com.nighthawk.spring_portfolio.mvc.cookingWebsite;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface recipesJPARepository extends JpaRepository<Recipes, Long> {
    Recipes findByName(String name);
    List<Recipes> findAllByOrderByNameAsc();
    List<Recipes> findAll();
<<<<<<< HEAD
    List<Recipes> findAllByCountry(String country);
    List<Recipes> findAllByTypeVeg(int vegetarian);
    List<Recipes> findAllByTypeNon(int nonVegetarian);

=======
    //List<Recipes> findByCountry();//
>>>>>>> f8a759ae6bbc4daae436bc79ae51db0039bbd7e0
}