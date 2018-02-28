package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Contact;

@Repository
public interface ContactDao extends JpaRepository<Contact, Long> {
 
	@Query("select c from Contact c where c.nom like :x")
	public Page<Contact> chercher(@Param("x")String mc, Pageable pageable);
}
