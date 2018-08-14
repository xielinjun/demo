package com.xlj.security.interfaces;

import com.xlj.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserDao extends JpaRepository<User, Integer> {
}
