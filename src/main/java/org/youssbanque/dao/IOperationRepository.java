package org.youssbanque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.youssbanque.entities.Operation;

public interface IOperationRepository extends JpaRepository<Operation, Long> {
    @Query("select o from Operation o where o.compte.codeCompte=:x order by dateOperation desc")
	public Page<Operation>  listOperations(@Param("x") String CodeCpte,Pageable pageable);
}
