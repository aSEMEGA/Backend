package com.example.Backend.Repository;

import com.example.Backend.Entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    List<Token> findByAllEmployeIdAndExpiredIsFalseAndRevokedIsFalse(Long id);


    Optional<Token> findByToken(String token);

    Token findByTokenAndRevokedIsFalseOrExpiredIsFalse(String token);
}
