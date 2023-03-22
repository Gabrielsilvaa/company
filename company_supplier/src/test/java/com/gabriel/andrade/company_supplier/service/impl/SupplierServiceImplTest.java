package com.gabriel.andrade.company_supplier.service.impl;

import com.gabriel.andrade.company_supplier.client.CepLaClient;
import com.gabriel.andrade.company_supplier.dto.SupplierDTO;
import com.gabriel.andrade.company_supplier.entity.SupplierEntity;
import com.gabriel.andrade.company_supplier.repository.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
class SupplierServiceImplTest {

    @Mock
    private CepLaClient cepLaClient;

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SupplierServiceImpl supplierService;

    @BeforeEach
    public void beforeEach(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void should_return_suppliers() {
        List<SupplierEntity> supplierEntities = new ArrayList();
        supplierEntities.add(new SupplierEntity());

        given(supplierRepository.findAll()).willReturn(supplierEntities);

        List<SupplierEntity> expected = supplierService.findSuppliers();

        assertEquals(expected, supplierEntities);
        verify(supplierRepository).findAll();
    }

    @Test
    void should_return_find_by_cnpj() {
        SupplierEntity supplierEntity = new SupplierEntity();
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setCnpj("02593356000101");

        given(supplierRepository.findCnpj("02593356000101")).willReturn(supplierEntity);

        SupplierEntity expected = supplierService.findSupplier(supplierDTO);

        assertEquals(expected, supplierEntity);
        verify(supplierRepository).findCnpj("02593356000101");
    }

    @Test
    void should_return_find_by_cpf() {
        SupplierEntity supplierEntity = new SupplierEntity();
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setCpf("10023575000");

        given(supplierRepository.findCpf("10023575000")).willReturn(supplierEntity);

        SupplierEntity expected = supplierService.findSupplier(supplierDTO);

        assertEquals(expected, supplierEntity);
        verify(supplierRepository).findCpf("10023575000");
    }

    @Test
    void should_return_find_by_name() {
        SupplierEntity supplierEntity = new SupplierEntity();
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setName("teste");

        given(supplierRepository.findName("teste")).willReturn(supplierEntity);

        SupplierEntity expected = supplierService.findSupplier(supplierDTO);

        assertEquals(expected, supplierEntity);
        verify(supplierRepository).findName("teste");
    }

    @Test
    void updateSupplier() {
    }

    @Test
    void saveSupplier() {
    }

    @Test
    void deletSupplier() {
    }
}