package com.example.demo;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.ws.FileWS;

public class FileTest {

	
	private FileWS fws;
	
	@Before
	public void setUp(){
		fws = new FileWS();
	}
	
	@After
	public void tearDown(){
		fws = null;
	}
	
	/*@Test
	public void getFileTest() throws IOException {
		fws.getFile();
	}*/
}
