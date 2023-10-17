package com.tec.workflix.repository;

import com.tec.workflix.models.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends CrudRepository<Users,Integer> {

    @Query(value = "SELECT email FROM users WHERE email = :email ", nativeQuery = true)
    List<String> checkUserEmail(@Param("email")String email);

    @Query(value = "SELECT password FROM users WHERE email = :email ", nativeQuery = true)
    String checkUserPasswordByEmail(@Param("email")String email);

    @Query(value = "SELECT * FROM users WHERE email = :email ", nativeQuery = true)
    Users getUserDetailsByEmail(@Param("email")String email);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users(first_name, last_name, email, password) VALUES(:first_name, :last_name, :email, :password)", nativeQuery = true)
    int registerNewUser(@Param("first_name") String first_name,
                        @Param("last_name") String last_name,
                        @Param("email") String email,
                        @Param("password") String password);
}
