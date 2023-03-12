package com.gabriel.andrade.company_supplier.service;

import com.gabriel.andrade.company_supplier.dto.CompanyDTO;
import com.gabriel.andrade.company_supplier.entity.CompanyEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    List<CompanyEntity> findCompanys();

    CompanyEntity findCompanyByCnpj(String cnpj);

    void updateCompany(CompanyDTO companyDTO);
    void saveCompany(CompanyDTO company);

    void deletCompany(String cnpj);

}
