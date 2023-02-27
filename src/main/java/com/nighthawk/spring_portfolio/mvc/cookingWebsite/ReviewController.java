package com.nighthawk.spring_portfolio.mvc.cookingWebsite;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
  private List<Review> reviews = new ArrayList<>();

  @PostMapping
  public Review createReview(@RequestBody Review review) {
    reviews.add(review);
    return review;
  }

  @GetMapping
  public List<Review> getReviews() {
    return reviews;
  }

  @ControllerAdvice
  public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
        ErrorResponse error = new ErrorResponse();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}

}

@Data
class Review {
  private String name;
  private String recipe;
  private String review;
}
