package org.youssbanque.metier;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.youssbanque.dao.ICompteRepository;
import org.youssbanque.dao.IOperationRepository;
import org.youssbanque.entities.Compte;
import org.youssbanque.entities.CompteCourant;
import org.youssbanque.entities.Operation;
import org.youssbanque.entities.Retrait;
import org.youssbanque.entities.Versement;

@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier{

	@Autowired
	private ICompteRepository compterepo;
	@Autowired
	private IOperationRepository operepo;
	
	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte cp = compterepo.findOne(codeCpte);
		if(cp==null) throw new RuntimeException("compte introuvable");
		return cp;
	}

	@Override
	public void verser(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		Versement v = new Versement(new Date(), montant, cp);
		operepo.save(v);
		cp.setSolde(cp.getSolde()+montant);
		compterepo.save(cp);
	}

	@Override
	public void retirer(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		double decouvertClient=0;
		if(cp instanceof CompteCourant){
			decouvertClient=((CompteCourant) cp).getDecouvert();
		}
		if(cp.getSolde()+decouvertClient < montant){
			throw new RuntimeException("solde insuffisant");
		}
		Retrait r = new Retrait(new Date(), montant, cp);
		operepo.save(r);
		cp.setSolde(cp.getSolde()-montant);
		compterepo.save(cp);
		
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		if(codeCpte1.equals(codeCpte2)){
			throw new RuntimeException("Operation impossible: virement sur le meme compte");
		}
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);
	}

	@Override
	public Page<Operation> listOperations(String codeCpte, int page, int size) {
		
		return operepo.listOperations(codeCpte, new PageRequest(page, size));
	}

}
