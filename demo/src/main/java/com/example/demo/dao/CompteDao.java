package com.example.demo.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.common.SqlQueries;
import com.example.demo.model.Compte;

public interface CompteDao extends JpaRepository<Compte, String>{

	
   //@Query("select c from Compte c where c.taux is not null")
	@Query(SqlQueries.GETALLCOMPTEEPAGRGNE)
   public Collection<Compte> getAllCompteEpargne();
	@Query(SqlQueries.GETCOMPTESBYCLIENT)
   public Collection<Compte> getCompteByClient(@Param("codeClient")Long codeClient);	
}
