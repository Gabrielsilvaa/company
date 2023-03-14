package com.gabriel.andrade.company_supplier.repository;

import com.gabriel.andrade.company_supplier.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    @Query(value = "select * from COMPANY_ENTITY where cnjp = :cnpj", nativeQuery = true)
    CompanyEntity findCnpj(@Param("cnpj") String cnpj);

    @Query(value = "select * from COMPANY_ENTITY  where FANTASY_NAME =:name", nativeQuery = true)
    CompanyEntity findName(@Param("name") String name);
}
