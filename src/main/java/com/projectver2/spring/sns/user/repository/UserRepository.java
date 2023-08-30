package com.projectver2.spring.sns.user.repository;

import com.projectver2.spring.sns.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserid(String userid);
    Optional<User> findByEmail(String email);

    Optional<User> deleteUserByUserid(String userid);


}
