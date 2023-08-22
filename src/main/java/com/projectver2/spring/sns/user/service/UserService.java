package com.projectver2.spring.sns.user.service;

import com.projectver2.spring.sns.user.domain.User;
import com.projectver2.spring.sns.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveOrUpdate(User user) {
        return userRepository.findByEmail(user.getEmail())
                .map(existingUser -> {
                    // 이미 존재하는 사용자의 경우 정보를 갱신
                    existingUser.setUsername(user.getUserid());
                    existingUser.setCity(user.getCity());
                    return userRepository.save(existingUser);
                }).orElseGet(() -> userRepository.save(user));  // 새 사용자는 저장
    }
    public Optional<User> findByUserid(String userid) {
        return userRepository.findByUserid(userid);
    }
}