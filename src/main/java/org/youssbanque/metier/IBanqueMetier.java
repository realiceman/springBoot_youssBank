package org.youssbanque.metier;

import org.springframework.data.domain.Page;
import org.youssbanque.entities.Compte;
import org.youssbanque.entities.Operation;

public interface IBanqueMetier {

	public Compte consulterCompte(String codeCpte);
	public void verser(String codeCpte, double montant);
	public void retirer(String codeCpte, double montant);
	public void virement(String codeCpte1, String codeCpte2, double montant);
	public Page<Operation> listOperations(String codeCpte, int page, int size);
}
