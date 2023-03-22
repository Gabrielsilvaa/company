package com.gabriel.andrade.company_supplier.service.impl;

import com.gabriel.andrade.company_supplier.client.CepLaClient;
import com.gabriel.andrade.company_supplier.dto.CepLaDTO;
import com.gabriel.andrade.company_supplier.dto.ContractDTO;
import com.gabriel.andrade.company_supplier.entity.ContractEntity;
import com.gabriel.andrade.company_supplier.repository.ContractRepository;
import com.gabriel.andrade.company_supplier.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    CepLaClient cepLaClient;


    @Override
    public List<ContractEntity> contracts() {
        return contractRepository.findAll();
    }

    @Override
    public void updateContract(ContractDTO contractDTO) {
        ContractEntity contract = contractRepository.findContract(contractDTO.getId());
        if (Objects.nonNull(contract)){
            contractRepository.save(setContract(contractDTO, contractDTO.getId()));
        }

    }

    @Override
    public void createContract(ContractDTO contract) {

        CepLaDTO cepLaDTO = cepLaClient.searchByZipCode(contract.getIdCompany().getCep());

        if ("PR".equals(cepLaDTO.getUf()) && age(contract.getIdSupplier().getDateOfBirth()) < 18){
           throw new RuntimeException("FORNECEDOR NAO TEM A IDADE PERMITIDA");
        }
        contractRepository.save(setContract(contract, null));
    }

    private static ContractEntity setContract(ContractDTO contract, Long id) {
        ContractEntity contractEntity = new ContractEntity();
        if (Objects.nonNull(id)){
            contractEntity.setIdContract(id);
        }
        contractEntity.setIdCompany(contract.getIdCompany());
        contractEntity.setCompanyName(contract.getCompanyName());
        contractEntity.setIdSupplier(contract.getIdSupplier());
        contractEntity.setSupplierName(contract.getSupplierName());
        contractEntity.setStatus(contract.getStatus());

        return contractEntity;
    }

    public static Integer age(final LocalDate aniversario) {
        final LocalDate dataAtual = LocalDate.now();
        final Period periodo = Period.between(aniversario, dataAtual);
        return periodo.getYears();
    }
}
