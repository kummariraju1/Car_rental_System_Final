package com.deepu.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepu.admin.entity.Admin;

public interface AdminRepository  extends JpaRepository<Admin, Integer>{

}
