package com.nighthawk.spring_portfolio.mvc.cookingWebsite;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inversoft.chef.domain.Recipes;

import java.util.List;

public interface recipesJPARepository extends JpaRepository<Recipes, Long> {
    Recipes findByName(String name);
    List<Recipes> findAllByOrderByNameAsc();
}