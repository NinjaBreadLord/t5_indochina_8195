package com.nighthawk.spring_portfolio.mvc.cookingWebsite;

import java.text.*;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
@Entity
@AllArgsConstructor
@Table(name="RECIPES") 
public class Recipes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String name;

    @Column(unique=true)
    private String ingredients;

    @Column(unique=true)
    private String description;

    public Recipes(String name, String ingredients, String description){
        this.name = name;
        this.ingredients = ingredients; 
        this.description = description; 
    }

 
}