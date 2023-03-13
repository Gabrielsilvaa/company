package com.gabriel.andrade.company_supplier.service.impl;

import com.gabriel.andrade.company_supplier.dto.CompanyDTO;
import com.gabriel.andrade.company_supplier.entity.CompanyEntity;
import com.gabriel.andrade.company_supplier.repository.CompanyRepository;
import com.gabriel.andrade.company_supplier.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<CompanyEntity> findCompanys() {
        return companyRepository.findAll();
    }

    @Override
    public CompanyEntity findCompanyByCnpj(String cnpj) {
        return companyRepository.findCnpj(cnpj);
    }

    @Override
    public void updateCompany(CompanyDTO companyDTO) {
        CompanyEntity cnpj = companyRepository.findCnpj(companyDTO.getCnpj());
        if (Objects.nonNull(cnpj)){
            CompanyEntity companyEntity = new CompanyEntity();
            companyEntity.setIdCompany(cnpj.getIdCompany());
            companyEntity.setCep(companyDTO.getCep());
            companyEntity.setCnpj(companyDTO.getCnpj());
            companyEntity.setFantasyName(companyDTO.getFantasyName());
            companyRepository.save(companyEntity);
        }
    }

    @Override
    public void saveCompany(CompanyDTO company) {
        if(companyRepository.findCnpj(company.getCnpj()) == null ){
            CompanyEntity companyEntity = new CompanyEntity();
            companyEntity.setCep(company.getCep());
            companyEntity.setCnpj(company.getCnpj());
            companyEntity.setFantasyName(company.getFantasyName());
            companyRepository.save(companyEntity);
        }

    }

    @Override
    public void deletCompany(String cnpj) {
        CompanyEntity company = companyRepository.findCnpj(cnpj);
        companyRepository.deleteById(company.getIdCompany());
    }
}
