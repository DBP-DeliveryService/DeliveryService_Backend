package com.deliveryapp.domain.menu.domain.repository;

import com.deliveryapp.domain.menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
