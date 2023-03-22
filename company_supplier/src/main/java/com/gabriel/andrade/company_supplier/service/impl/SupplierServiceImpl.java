package com.gabriel.andrade.company_supplier.service.impl;

import com.gabriel.andrade.company_supplier.client.CepLaClient;
import com.gabriel.andrade.company_supplier.dto.CepLaDTO;
import com.gabriel.andrade.company_supplier.dto.SupplierDTO;
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

    @Autowired
    CepLaClient cepLaClient;

    @Override
    public List<SupplierEntity> findSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public List<SupplierEntity> findSupplier(SupplierDTO supplierDTO) {
        if (Objects.nonNull(supplierDTO.getDocumentNumber())){
            return supplierRepository.findByDocumentNumbers(supplierDTO.getDocumentNumber());
        }
        return supplierRepository.findName(supplierDTO.getName());
    }

    @Override
    public void updateSupplier(SupplierDTO supplierDTO) {
            SupplierEntity supplier = supplierRepository.findByDocumentNumber(supplierDTO.getDocumentNumber());
            supplierRepository.save(buildSupplier(supplierDTO, supplier.getId() ));
    }

    @Override
    public void saveSupplier(SupplierDTO supplier) {
        CepLaDTO cepLa = cepLaClient.searchByZipCode(supplier.getCep());

        if (Objects.isNull(cepLa)){
            throw new RuntimeException("CEP NAO EXISTENTE");
        }
        validateSupplier(supplier);
        if (Objects.nonNull(supplier.getDocumentNumber())){
            supplierRepository.save(buildSupplier(supplier, null));
        }
    }


    @Override
    public void deletSupplier(SupplierDTO supplierDTO) {
        SupplierEntity entity = supplierRepository.findByDocumentNumber(supplierDTO.getDocumentNumber());
        if (Objects.nonNull(entity)){
            supplierRepository.deleteById(entity.getId());
        }
    }

    private void validateSupplier(SupplierDTO supplier) {
        SupplierEntity entity = supplierRepository.findByDocumentNumber(supplier.getDocumentNumber());
        if (entity != null){
            throw new RuntimeException("cnpj / cpf ja cadastrado");
        }
    }

    private static SupplierEntity buildSupplier(SupplierDTO supplier, Long id) {
        SupplierEntity supplierEntity = new SupplierEntity();
        if (Objects.nonNull(id)){
            supplierEntity.setId(id);
        }
        supplierEntity.setCep(supplier.getCep());
        supplierEntity.setName(supplier.getName());
        supplierEntity.setDocumentNumber(supplier.getDocumentNumber());
        supplierEntity.setTypeDocument(supplier.getTypeDocument());
        supplierEntity.setEmail(supplier.getEmail());
        supplierEntity.setRg(supplier.getRg());
        supplierEntity.setDateOfBirth(supplier.getDateOfBirth());
        return supplierEntity ;
    }
}
