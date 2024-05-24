package com.deliveryapp.domain.user.domain.repository;

import com.deliveryapp.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
