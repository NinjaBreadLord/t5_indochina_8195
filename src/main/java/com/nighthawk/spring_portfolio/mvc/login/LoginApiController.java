package com.nighthawk.spring_portfolio.mvc.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.text.SimpleDateFormat;
@RestController
@RequestMapping("/api/login")
public class LoginApiController {

    @Autowired
    private LoginJpaRepository repository;
    /*
    GET List of People
     */
    @GetMapping("/")
    public ResponseEntity<List<Login>> getLogin() {
        return new ResponseEntity<>( repository.findAllByOrderByNameAsc(), HttpStatus.OK);
    }
    /*
    GET individual Person using ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Login> getLogin(@PathVariable long id) {
        Optional<Login> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Login person = optional.get();  // value from findByID
            return new ResponseEntity<>(person, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Login> deleteLogin(@PathVariable long id) {
        Optional<Login> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Login person = optional.get();  // value from findByID
            repository.deleteById(id);  // value from findByID
            return new ResponseEntity<>(person, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
        }
  
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    /*
    POST Aa record by Requesting Parameters from URI
     */
    @PostMapping( "/post")
    public ResponseEntity<Object> postPerson(@RequestParam("email") String email,
                                             @RequestParam("password") String password
                                             ) {



        Login person = new Login(email, password);
        repository.save(person);
        return new ResponseEntity<>(email +" is created successfully", HttpStatus.CREATED);
    }


    @GetMapping("/toString/{id}")
        public String personToString(@PathVariable long id) {
            Optional<Login> optional = repository.findById(id);
            if (optional.isPresent()) {
                Login person = optional.get();
                String toStringOutput = person.toString();
                return toStringOutput;
            }
            return "No person exists";
        }
}