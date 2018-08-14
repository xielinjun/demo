package com.xlj.jaxws.daointerfaces;


import com.xlj.jaxws.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserDao extends JpaRepository<User, Integer> {
}
