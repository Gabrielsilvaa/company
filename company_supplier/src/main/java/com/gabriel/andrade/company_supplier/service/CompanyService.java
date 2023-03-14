package com.gabriel.andrade.company_supplier.service;

import com.gabriel.andrade.company_supplier.dto.CompanyDTO;
import com.gabriel.andrade.company_supplier.entity.CompanyEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    List<CompanyEntity> findCompanys();

    CompanyEntity findCompanyByCnpj(CompanyDTO companyDTO);

    CompanyEntity updateCompany(CompanyDTO companyDTO);
    CompanyEntity saveCompany(CompanyDTO company);

    void deletCompany(String cnpj);

}
