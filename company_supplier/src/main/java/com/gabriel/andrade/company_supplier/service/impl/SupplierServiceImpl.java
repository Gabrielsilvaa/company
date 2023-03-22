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
        if (Objects.nonNull(supplierDTO.getCpf())){
            return supplierRepository.findCpfs(supplierDTO.getCpf());
        } else if (Objects.nonNull(supplierDTO.getCnpj())) {
            return supplierRepository.findCnpjs(supplierDTO.getCnpj());
        }
        return supplierRepository.findName(supplierDTO.getName());
    }

    @Override
    public void updateSupplier(SupplierDTO supplierDTO) {
        if (Objects.nonNull(supplierDTO.getCpf())){
            SupplierEntity cpf = supplierRepository.findCpf(supplierDTO.getCpf());
            supplierRepository.save(buildSupplier(supplierDTO, cpf.getId() ));
        } else if (Objects.nonNull(supplierDTO.getCnpj())) {
            SupplierEntity cnpj = supplierRepository.findCnpj(supplierDTO.getCnpj());
            supplierRepository.save(buildSupplier(supplierDTO, cnpj.getId() ));
        }
    }

    @Override
    public void saveSupplier(SupplierDTO supplier) {
        CepLaDTO cepLa = cepLaClient.searchByZipCode(supplier.getCep());

        if (Objects.isNull(cepLa)){
            throw new RuntimeException("CEP NAO EXISTENTE");
        }
        validateSupplier(supplier);
        if (Objects.nonNull(supplier.getCpf()) || Objects.nonNull(supplier.getCnpj())){
            supplierRepository.save(buildSupplier(supplier, null));
        }
    }


    @Override
    public void deletSupplier(SupplierDTO supplierDTO) {
        SupplierEntity repositoryCnpj = supplierRepository.findCnpj(supplierDTO.getCnpj());
        SupplierEntity repositoryCpf = supplierRepository.findCpf(supplierDTO.getCpf());
        if (Objects.nonNull(repositoryCpf)){
            supplierRepository.deleteById(repositoryCpf.getId());
        } else if (Objects.nonNull(repositoryCnpj)) {
            supplierRepository.deleteById(repositoryCnpj.getId());
        }
    }

    private void validateSupplier(SupplierDTO supplier) {
        SupplierEntity cnpj = supplierRepository.findCnpj(supplier.getCnpj());
        SupplierEntity cpf = supplierRepository.findCpf(supplier.getCpf());
        if (Objects.nonNull(cnpj) || Objects.nonNull(cpf)){
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
        supplierEntity.setCnpj(supplier.getCnpj());
        supplierEntity.setEmail(supplier.getEmail());
        supplierEntity.setCpf(supplier.getCpf());
        supplierEntity.setRg(supplier.getRg());
        supplierEntity.setDateOfBirth(supplier.getDateOfBirth());
        return supplierEntity ;
    }
}
