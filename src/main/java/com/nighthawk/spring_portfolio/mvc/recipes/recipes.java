package com.nighthawk.spring_portfolio.mvc.recipes;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.util.GregorianCalendar;
import java.util.ArrayList;


@Data 
@AllArgsConstructor
@Table(name="RECIPES") 
@Entity
public class recipes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String name;

    @Column(unique=true)
    private String ingredients;

    @Column(unique=true)
    private String description;

    @Column(unique=true)
    private String country;

    @Column(unique=true)
    private int preparation;
    

    public recipes(String name, String ingredients, String description,String country, int preparation){
        this.name = name;
        this.ingredients = ingredients; 
        this.description = description; 
        this.country = country;
        this.preparation = preparation;
    }

    public recipes(){

    }

    public static recipes[] init(){
        recipes GrilledCheese = new recipes("Grilled Cheese","Bread, Cheese","It is very tasty","America",10);

        recipes recipes[] = {GrilledCheese};
        return(recipes);
    }

    public static void main(String[] args){
        recipes recipes[] = init();
        for (recipes recipe: recipes){
            System.out.println(recipe);
        }
    }
}