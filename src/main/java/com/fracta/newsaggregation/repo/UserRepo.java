package com.fracta.newsaggregation.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fracta.newsaggregation.model.User;
import com.fracta.newsaggregation.model.VerificationToken;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByUserId(Long userId);
	Optional<User> findByUsername(String username);

}
