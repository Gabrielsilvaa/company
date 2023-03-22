package com.gabriel.andrade.company_supplier.repository;

import com.gabriel.andrade.company_supplier.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

    @Query(value = "select * from COMPANY_ENTITY where cnjp = :cnpj", nativeQuery = true)
    CompanyEntity findCnpj(@Param("cnpj") String cnpj);

    @Query(value = "SELECT * FROM COMPANY_ENTITY  where cnjp LIKE CONCAT('%',:cnpj,'%')", nativeQuery = true)
    List<CompanyEntity> findCnpjs(@Param("cnpj") String cnpj);

    @Query(value = "SELECT * FROM COMPANY_ENTITY  WHERE  FANTASY_NAME LIKE CONCAT('%',:name,'%')", nativeQuery = true)
    List<CompanyEntity> findName(@Param("name") String name);
}
