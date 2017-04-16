package org.youssbanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.youssbanque.entities.Compte;

public interface ICompteRepository extends JpaRepository<Compte, String>{

}
