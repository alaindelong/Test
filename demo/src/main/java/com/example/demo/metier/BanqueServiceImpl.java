package com.example.demo.metier;

import java.util.Date;

import org.hamcrest.core.IsInstanceOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ClientDao;
import com.example.demo.dao.CompteDao;
import com.example.demo.dao.OperationDao;
import com.example.demo.model.Client;
import com.example.demo.model.Compte;
import com.example.demo.model.CompteCourant;
import com.example.demo.model.Operation;
import com.example.demo.model.Retrait;
import com.example.demo.model.Versement;

@Service
@Transactional
public class BanqueServiceImpl implements BanqueService {
	
	@Autowired
	private CompteDao compteDao;
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private OperationDao operationDao;

	@Override
	public Compte consulterCompte(String codeCompte) {

        Compte cp = compteDao.findOne(codeCompte);
        if(cp == null){
        	throw new RuntimeException("compte non trouvé");
        }
		return cp;
	}

	@Override
	public void verser(String codeCompte, double montant) {
		Versement v = new Versement(new Date(), montant);
		Compte c = consulterCompte(codeCompte);
		v.setCompte(c);
		operationDao.save(v);
		c.setSolde(c.getSolde()+montant);
		compteDao.save(c);
		
	}

	@Override
	public void retirer(String codeCompte, double montant) {
		Retrait r = new Retrait(new Date(), montant);
		Compte c = consulterCompte(codeCompte);
		double faciliteCaisse = 0;
		r.setCompte(c);
		operationDao.save(r);
		if(c instanceof CompteCourant){
			 faciliteCaisse = ((CompteCourant)c).getDecouvert();
		}
		if(c.getSolde()+faciliteCaisse<montant)
			throw new RuntimeException("solde insuffisant");
		c.setSolde(c.getSolde()-montant);
		compteDao.save(c);
		
	}

	@Override
	public void virer(String codeCompte1, String codeCompte2, double montant) {
		retirer(codeCompte1, montant);
		verser(codeCompte2, montant);
		
	}

	@Override
	public Client addClient(Client c) {
		
		return clientDao.save(c);
	}

	@Override
	public Compte creerCompte(Compte c) {
		
		return compteDao.save(c);
	}

	@Override
	public Page<Operation> listeOperation(String codeCompte, int page, int size) {
		return operationDao.listeOperation(codeCompte, new PageRequest(page, size));
	}

}
