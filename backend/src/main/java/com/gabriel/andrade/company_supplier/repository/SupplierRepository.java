package com.gabriel.andrade.company_supplier.repository;

import com.gabriel.andrade.company_supplier.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {



    @Query(value = "SELECT * FROM SUPPLIER_ENTITY  WHERE  DOCUMENT_NUMBER LIKE CONCAT('%',:documentNumber,'%')", nativeQuery = true)
    List<SupplierEntity> findCnpjs(@Param("documentNumber") String documentNumber);

    @Query(value = "select * from SUPPLIER_ENTITY  where DOCUMENT_NUMBER = :documentNumber", nativeQuery = true)
    SupplierEntity findCpf(@Param("documentNumber") String documentNumber);

    @Query(value = " SELECT * FROM SUPPLIER_ENTITY  WHERE  DOCUMENT_NUMBER LIKE CONCAT('%',:documentNumber,'%') ", nativeQuery = true)
    List<SupplierEntity> findByDocumentNumbers(@Param("documentNumber") String documentNumber);

    @Query(value = "select * from SUPPLIER_ENTITY  where name  LIKE CONCAT('%',:name,'%')", nativeQuery = true)
    List<SupplierEntity> findName(@Param("name") String name);

    @Query(value = "select * from SUPPLIER_ENTITY  where DOCUMENT_NUMBER = :documentNumber", nativeQuery = true)
    SupplierEntity findByDocumentNumber(@Param("documentNumber") String documentNumber);

}
