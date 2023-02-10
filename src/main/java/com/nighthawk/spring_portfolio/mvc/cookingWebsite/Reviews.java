package com.nighthawk.spring_portfolio.mvc.cookingWebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class Reviews {

    private List<Review> reviews = new ArrayList<>();

    @GetMapping("/api/reviews")
    public List<Review> getReviews() {
        return reviews;
    }

    @PostMapping("/api/reviews")
    public void addReview(@RequestBody Review review) {
        reviews.add(review);
    }

    static class Review {
        private String productId;
        private String text;
        private int rating;
        private String recipe;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getRating() {
            return rating;
        }

        public String getRecipe(){
            return recipe;
        }

        public void setRecipe(String recipe){
            this.recipe = recipe;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    }
    
}
