package com.xlj.jpaspringdata.daointerfaces;

import com.xlj.jpaspringdata.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface IUserDao extends JpaRepository<User, Integer> {

    User findByName(String username);

}
