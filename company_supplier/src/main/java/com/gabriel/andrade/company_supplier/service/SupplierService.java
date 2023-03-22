package com.gabriel.andrade.company_supplier.service;

import com.gabriel.andrade.company_supplier.dto.SupplierDTO;
import com.gabriel.andrade.company_supplier.entity.SupplierEntity;

import java.util.List;

public interface SupplierService {

    List<SupplierEntity> findSuppliers();

    List<SupplierEntity> findSupplier(SupplierDTO supplierDTO);

    void updateSupplier(SupplierDTO supplierDTO);
    void saveSupplier(SupplierDTO supplier);

    void deletSupplier(SupplierDTO supplierDTO);


}
