package com.xlj.web.domain.repository;


import com.xlj.web.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findUsersByName(String name);

    List<User> findUsersByAgeBetween(int start, int end);

}
