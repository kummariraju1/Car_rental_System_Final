package com.deepu.cartservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deepu.cartservice.entity.Cart;

import jakarta.transaction.Transactional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	@Query("select c from Cart c where c.userid=?1")
	public List<Cart> findByCarId(Integer uid);
    
	@Modifying
	@Transactional
	@Query("delete from Cart c where c.userid=?1")
	public void deleteByUserId(Integer id);
}
