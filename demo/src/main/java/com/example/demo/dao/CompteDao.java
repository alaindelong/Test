package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Compte;

public interface CompteDao extends JpaRepository<Compte, String>{

}
