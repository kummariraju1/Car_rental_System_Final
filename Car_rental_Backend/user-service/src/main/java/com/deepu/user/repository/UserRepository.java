package com.deepu.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepu.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
