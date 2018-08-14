package com.xlj.rmi.interfaces;

import com.xlj.rmi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Integer> {
}
