package com.gabriel.andrade.company_supplier.service;

import com.gabriel.andrade.company_supplier.dto.SupplierDTO;
import com.gabriel.andrade.company_supplier.entity.SupplierEntity;

import java.util.List;

public interface SupplierService {

    List<SupplierEntity> findSuppliers();

    SupplierEntity findSupplier(String cnpj, String cpf);

    SupplierDTO updateSupplier(String cnpj, String cpf, SupplierDTO supplierDTO);
    void saveSupplier(SupplierDTO supplier);

    void deletSupplier(String cnpj, String cpf);


}
