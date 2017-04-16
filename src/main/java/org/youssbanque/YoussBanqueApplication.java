package org.youssbanque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.boot.autoconfigure.reactor.ReactorAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.youssbanque.dao.IClientRepository;
import org.youssbanque.dao.ICompteRepository;
import org.youssbanque.dao.IOperationRepository;
import org.youssbanque.entities.Client;import org.youssbanque.entities.Compte;
import org.youssbanque.entities.CompteCourant;
import org.youssbanque.entities.CompteEpargne;
import org.youssbanque.entities.Retrait;
import org.youssbanque.entities.Versement;
import org.youssbanque.metier.IBanqueMetier;;

@SpringBootApplication
public class YoussBanqueApplication implements CommandLineRunner {
    @Autowired
	private IClientRepository iclientrepo;
    @Autowired
    private ICompteRepository icompterepo;
    @Autowired
    private IOperationRepository ioprepo;
    @Autowired
    private IBanqueMetier bankmetier;
    
	public static void main(String[] args) {
	 SpringApplication.run(YoussBanqueApplication.class, args);

	}

	@Override
	public void run(String... arg0) throws Exception {
//		Client c1 = iclientrepo.save(new Client("youssef", "youss.hark@gmail.com"));
//		Client c2 = iclientrepo.save(new Client("francois", "francois.henzlick@gmail.com"));
//	    Compte cpte1 = icompterepo.save(new CompteCourant("c1", new Date(), 90000, c1, 60000));
//	    Compte cpte2 = icompterepo.save(new CompteEpargne("c2", new Date(), 6000, c1, 5.5));
//	    ioprepo.save(new Versement(new Date(), 70, cpte1));
//	    ioprepo.save(new Retrait(new Date(), 500, cpte2));
//	    
//		Compte cpte2 = icompterepo.save(new CompteEpargne("c2", new Date(), 6000, c2, 5.5));
	}
}
