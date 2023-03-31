package com.gabriel.andrade.company_supplier.service.impl;

import com.gabriel.andrade.company_supplier.client.CepLaClient;
import com.gabriel.andrade.company_supplier.dto.CepLaDTO;
import com.gabriel.andrade.company_supplier.dto.CompanyDTO;
import com.gabriel.andrade.company_supplier.entity.CompanyEntity;
import com.gabriel.andrade.company_supplier.repository.CompanyRepository;
import com.gabriel.andrade.company_supplier.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CepLaClient cepLaClient;

    @Override
    public List<CompanyEntity> findCompanys() {
        return companyRepository.findAll();
    }

    @Override
    public List<CompanyEntity> findCompanyByCnpj(CompanyDTO companyDTO) {

        if (Objects.nonNull(companyDTO.getFantasyName())){
            return companyRepository.findName(companyDTO.getFantasyName());
        }
        return companyRepository.findCnpjs(companyDTO.getCnpj());
    }

    @Override
    public CompanyEntity updateCompany(CompanyDTO companyDTO) {
        CompanyEntity cnpj = companyRepository.findCnpj(companyDTO.getCnpj());
        if (Objects.isNull(cnpj)){
            throw new RuntimeException("CNPJ NAO EXISTE");
        }
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setIdCompany(cnpj.getIdCompany());
        companyEntity.setCep(companyDTO.getCep());
        companyEntity.setCnpj(companyDTO.getCnpj());
        companyEntity.setFantasyName(companyDTO.getFantasyName());

        return companyRepository.save(companyEntity);
    }

    @Override
    public CompanyEntity saveCompany(CompanyDTO company) {
        CepLaDTO cepLa = cepLaClient.searchByZipCode(company.getCep());

        if (Objects.isNull(cepLa)){
            throw new RuntimeException("CEP NAO EXISTENTE");
        }

        if(Objects.nonNull(companyRepository.findCnpj(company.getCnpj()))){
            throw new RuntimeException("CNPJ JA EXISTENTE");
        }
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setCep(company.getCep());
        companyEntity.setCnpj(company.getCnpj());
        companyEntity.setFantasyName(company.getFantasyName().toUpperCase(Locale.ROOT));

        return companyRepository.save(companyEntity);
    }

    @Override
    public void deletCompany(String cnpj) {
        CompanyEntity company = companyRepository.findCnpj(cnpj);
        companyRepository.deleteById(company.getIdCompany());
    }
}
