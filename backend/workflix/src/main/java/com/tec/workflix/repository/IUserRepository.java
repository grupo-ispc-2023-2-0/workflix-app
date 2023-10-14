package com.tec.workflix.repository;

import com.tec.workflix.models.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IUserRepository extends CrudRepository<Users,Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO USERS(first_name, last_name, email, password) VALUES(:first_name, :last_name, :email, :password)", nativeQuery = true)
    int registerNewUser(@Param("first_name") String first_name,
                        @Param("last_name") String last_name,
                        @Param("email") String email,
                        @Param("password") String password);
}
