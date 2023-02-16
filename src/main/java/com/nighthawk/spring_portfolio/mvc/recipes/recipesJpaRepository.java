package com.nighthawk.spring_portfolio.mvc.recipes;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface recipesJpaRepository extends JpaRepository<recipes, Long> {
    recipes findByName(String name);
    List<recipes> findAllByOrderByNameAsc();
    List<recipes> findAll();
    List<recipes> findAllByRegion(String region);
}