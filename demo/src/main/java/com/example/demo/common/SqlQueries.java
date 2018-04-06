package com.example.demo.common;

public class SqlQueries {

	public static final String GETALLCOMPTEEPAGRGNE = "SELECT C FROM Compte C WHERE C.taux IS NOT NULL";
	
	public static final String GETCOMPTESBYCLIENT = "SELECT C FROM Compte C " 
			+ "INNER JOIN C.client CL WHERE CL.codeClient =:codeClient";
			
}
