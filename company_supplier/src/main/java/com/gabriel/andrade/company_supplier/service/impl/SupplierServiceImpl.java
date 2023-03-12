package com.gabriel.andrade.company_supplier.service.impl;

import com.gabriel.andrade.company_supplier.dto.SupplierDTO;
import com.gabriel.andrade.company_supplier.entity.CompanyEntity;
import com.gabriel.andrade.company_supplier.entity.SupplierEntity;
import com.gabriel.andrade.company_supplier.repository.SupplierRepository;
import com.gabriel.andrade.company_supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public List<SupplierEntity> findSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public SupplierEntity findSupplier(String cnpj, String cpf) {
        SupplierEntity supplierCnpj = supplierRepository.findCnpj(cnpj);
        if (Objects.nonNull(supplierCnpj)){
            return supplierCnpj;
        }
        return supplierRepository.findCpf(cpf);
    }

    @Override
    public SupplierDTO updateSupplier(String cnpj, String cpf, SupplierDTO supplierDTO) {
        return null;
    }

    @Override
    public void saveSupplier(SupplierDTO supplier) {
        SupplierEntity supplierEntity = new SupplierEntity();
        supplierEntity.setCep(supplier.getCep());
        supplierEntity.setName(supplier.getName());
        supplierEntity.setCnpj(supplier.getCnpj());
        supplierEntity.setEmail(supplier.getEmail());
        supplierEntity.setCpf(supplierEntity.getCpf());
        supplierRepository.save(supplierEntity);
    }

    @Override
    public void deletSupplier(String cnpj, String cpf) {
        SupplierEntity repositoryCnpj = supplierRepository.findCnpj(cnpj);
        SupplierEntity repositoryCpf = supplierRepository.findCpf(cpf);
        if (Objects.nonNull(repositoryCpf)){
            supplierRepository.deleteById(repositoryCpf.getId()));
        } else if (Objects.nonNull(repositoryCnpj)) {

        }
    }
}
