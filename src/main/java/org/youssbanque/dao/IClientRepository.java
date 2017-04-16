package org.youssbanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.youssbanque.entities.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {

}
