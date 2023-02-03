package com.nighthawk.spring_portfolio.mvc.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface LoginJpaRepository extends JpaRepository<Login, Long> {
    Login findByEmail(String email);

    List<Login> findAllByOrderByNameAsc();

    List<Login> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);

    @Query(
            value = "SELECT * FROM Person p WHERE p.name LIKE ?1 or p.email LIKE ?1",
            nativeQuery = true)
    List<Login> findByLikeTermNative(String term);

}