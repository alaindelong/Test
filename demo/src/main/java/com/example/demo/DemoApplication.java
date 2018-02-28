package com.example.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.ClientDao;
import com.example.demo.dao.CompteDao;
import com.example.demo.dao.ContactDao;
import com.example.demo.dao.OperationDao;
import com.example.demo.metier.BanqueService;
import com.example.demo.model.Client;
import com.example.demo.model.Compte;
import com.example.demo.model.CompteCourant;
import com.example.demo.model.CompteEpargne;
import com.example.demo.model.Contact;
import com.example.demo.model.Operation;
import com.example.demo.model.Retrait;
import com.example.demo.model.Versement;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ContactDao contactDao;
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private CompteDao compteDao;
	@Autowired
	private OperationDao operationDao;
	@Autowired
	private BanqueService banqueService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		/*DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactDao.save(new Contact("fouo", "alain",df.parse("11/01/1990") , "ad@gmail.com", 75451014, "alain.png"));
		contactDao.findAll().forEach(c -> {
			System.out.println(c.getNom());
		});*//*
		Client c1 = clientDao.save(new Client("alain","a@gmail.com"));
		System.out.println(c1.getNomClient());
		 Compte ccc = new CompteCourant("C1", 200, new Date(), 6000);
		 ccc.setClient(c1);
		Compte cc = compteDao.save(ccc);
		System.out.println(cc.getSolde());
		Compte cccc = new CompteEpargne("C2", 300, new Date(), 0.2);
		cccc.setClient(c1);
		Compte ce = compteDao.save(cccc);
		System.out.println(ce.getSolde());
		Operation o = new Versement(new Date(), 100);
		o.setCompte(ce); 
		Operation o1 = operationDao.save(o);
		System.out.println(o1.getMontant());
		Operation oo = new Retrait(new Date(), 50);
		oo.setCompte(cc);        
		Operation o2 = operationDao.save(oo);
		System.out.println(o2.getMontant());
		banqueService.verser("C1", 77777);*/
	}
}
