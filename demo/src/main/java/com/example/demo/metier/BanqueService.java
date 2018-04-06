package com.example.demo.metier;

import java.util.Collection;

import org.springframework.data.domain.Page;

import com.example.demo.model.Client;
import com.example.demo.model.Compte;
import com.example.demo.model.Operation;

public interface BanqueService {
	public Compte consulterCompte(String codeCompte);
	public void verser(String codeCompte, double montant);
	public void retirer(String codeCompte, double montant);
	public void virer(String codeCompte1, String codeCompte2, double montant);
	public Client addClient(Client c);
	public Compte creerCompte(Compte c);
	public Page<Operation> listeOperation(String codeCompte, int page, int size);
    public Collection<Compte> getAllCompte();
    public Collection<Client> getAllClient();
    public Collection<Compte> getCompteByClient(Long clientId);
}
