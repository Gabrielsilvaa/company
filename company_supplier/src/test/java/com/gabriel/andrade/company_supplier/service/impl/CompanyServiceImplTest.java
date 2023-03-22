package com.gabriel.andrade.company_supplier.service.impl;

import com.gabriel.andrade.company_supplier.client.CepLaClient;
import com.gabriel.andrade.company_supplier.dto.CompanyDTO;
import com.gabriel.andrade.company_supplier.entity.CompanyEntity;
import com.gabriel.andrade.company_supplier.repository.CompanyRepository;
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

class CompanyServiceImplTest {

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private CepLaClient cepLaClient;

    @InjectMocks
    private CompanyServiceImpl companyService;

    @BeforeEach
    public void beforeEach(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void should_return_companys() {
        List<CompanyEntity> companyEntities = new ArrayList();
        companyEntities.add(new CompanyEntity());

        given(companyRepository.findAll()).willReturn(companyEntities);

        List<CompanyEntity> expected = companyService.findCompanys();

        assertEquals(expected, companyEntities);
        verify(companyRepository).findAll();
    }

    @Test
    void should_return_find_by_cnpjs() {
        List<CompanyEntity> companyEntities = new ArrayList<>();
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setCnpj("02593356000101");

        given(companyRepository.findCnpjs("02593356000101")).willReturn(companyEntities);

        List<CompanyEntity> expected = companyService.findCompanyByCnpj(companyDTO);

        assertEquals(expected, companyEntities);
        verify(companyRepository).findCnpjs("02593356000101");
    }

    @Test
    void should_return_find_by_name() {
        List<CompanyEntity> companyEntities = new ArrayList<>();
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setFantasyName("teste");

        given(companyRepository.findName("teste")).willReturn(companyEntities);

        List<CompanyEntity> expected = companyService.findCompanyByCnpj(companyDTO);

        assertEquals(expected, companyEntities);
        verify(companyRepository).findName("teste");
    }

//    @Test
//    void updateCompany() {
//        CompanyDTO companyDTO = new CompanyDTO();
//        companyDTO.setCep("06825025");
//        companyDTO.setCnpj("02593356000101");
//        companyDTO.setFantasyName("teste");
//
//        CompanyEntity company = new CompanyEntity();
//
//        given(companyRepository.findCnpj("02593356000101")).willReturn(company);
//        CompanyEntity companyEntity = companyService.updateCompany(companyDTO);
//
//        verify(companyRepository).save(company);
//        verify(companyRepository).findCnpj("02593356000101");
//
//    }

//    @Test
//    void saveCompany() {
//        CompanyEntity companyEntity = new CompanyEntity();
//        companyEntity.setCep("06825025");
//        companyEntity.setCnpj("02593356000101");
//        companyEntity.setFantasyName("teste");
//
//        CompanyDTO companyDTO = new CompanyDTO();
//        companyDTO.setCep("06825025");
//        companyDTO.setCnpj("02593356000101");
//        companyDTO.setFantasyName("teste");
//
//        when(companyRepository.save(companyEntity)).thenReturn(companyEntity);
//
//        CompanyEntity created = companyService.saveCompany(companyDTO);
//
//        assertThat(created).isSameAs(companyEntity);
//        verify(companyRepository).save(companyEntity);
//    }

    @Test
    void deletCompany() {


    }
}