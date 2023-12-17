package com.johnson.interswitch.repository;

import com.johnson.interswitch.model.User;
import com.johnson.interswitch.model.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Johnson on 16/12/2023
 */
public interface CartRepository extends JpaRepository<UserCart, Long> {
    UserCart findCartByUser(User user);
}
