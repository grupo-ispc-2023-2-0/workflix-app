package com.tec.workflix.repository;

import com.tec.workflix.models.Users;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<Users,Integer> {
}
