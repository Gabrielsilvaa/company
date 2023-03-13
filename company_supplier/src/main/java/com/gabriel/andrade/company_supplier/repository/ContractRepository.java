package com.gabriel.andrade.company_supplier.repository;

import com.gabriel.andrade.company_supplier.entity.ContractEntity;
import com.gabriel.andrade.company_supplier.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContractRepository extends JpaRepository<ContractEntity, Long> {
    @Query(value = "select * from CONTRACT_ENTITY  where ID_CONTRACT = :idcontract", nativeQuery = true)
    ContractEntity findContract(@Param("idcontract") Long idcontract);
}
