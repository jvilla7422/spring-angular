package com.jvisoft.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jvisoft.Model.UserX;

@Repository
public interface UserRepository extends CrudRepository<UserX, Long>{}
