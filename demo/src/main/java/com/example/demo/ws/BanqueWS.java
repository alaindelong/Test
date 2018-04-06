package com.example.demo.ws;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.metier.BanqueService;
import com.example.demo.model.Client;
import com.example.demo.model.Compte;

@RestController
public class BanqueWS {

	@Autowired
	private BanqueService banqueService;
	
	@RequestMapping(value="/comptes", method=RequestMethod.GET)
	public Collection<Compte> getAllCompte(){
		return banqueService.getAllCompte();
	}
	
	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public Collection<Client> getAllClient(){
		return banqueService.getAllClient();
	}
	
	@RequestMapping(value="/comptes/{codeClient}", method=RequestMethod.GET)
	public Collection<Compte> getCompteByClient(@PathVariable("codeClient") Long codeClient){
		return banqueService.getCompteByClient(codeClient);
	}
	
	@RequestMapping(value="/virement/{cc1}/{cc2}/{montant}", method=RequestMethod.GET)
	public String virement(@PathVariable("cc1") String cc1,@PathVariable("cc2") String cc2,
			               @PathVariable("montant")double montant){
		  banqueService.virer(cc1, cc2, montant);
		return "vous avez virer le montant de "+montant+" du compte "+cc1+" vers le compte "+cc2;
	}
}
