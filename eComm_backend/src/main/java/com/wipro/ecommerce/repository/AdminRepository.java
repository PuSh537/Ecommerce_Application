package com.wipro.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.ecommerce.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Optional<Admin> findByUsername(String username);

}
