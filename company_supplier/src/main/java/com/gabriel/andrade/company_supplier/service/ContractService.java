package com.gabriel.andrade.company_supplier.service;

import com.gabriel.andrade.company_supplier.entity.CompanyEntity;
import com.gabriel.andrade.company_supplier.entity.ContractEntity;

import java.util.List;

public interface ContractService {

    List<ContractEntity> contracts();

    void updateContract();

    void createContract();


}
