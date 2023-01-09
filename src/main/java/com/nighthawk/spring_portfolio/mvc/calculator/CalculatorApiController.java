package com.nighthawk.spring_portfolio.mvc.calculator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/calculator")
public class CalculatorApiController {
    @GetMapping("/{expression}")
    public ResponseEntity<String> calculate(@PathVariable String expression) {
      Calculator finalsolve = new Calculator(expression);
      String json = finalsolve.toString();
      return ResponseEntity.ok(json);
    }
}
