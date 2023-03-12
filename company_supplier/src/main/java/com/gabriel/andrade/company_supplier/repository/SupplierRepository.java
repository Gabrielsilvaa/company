package com.gabriel.andrade.company_supplier.repository;

import com.gabriel.andrade.company_supplier.entity.CompanyEntity;
import com.gabriel.andrade.company_supplier.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {

    @Query(value = "select * from tbg_supplier where cnjp = :cnpj", nativeQuery = true)
    SupplierEntity findCnpj(@Param("cnpj") String cnpj);

    @Query(value = "select * from tbg_supplier where cpf = :cpf", nativeQuery = true)
    SupplierEntity findCpf(@Param("cpf") String cpf);

}
