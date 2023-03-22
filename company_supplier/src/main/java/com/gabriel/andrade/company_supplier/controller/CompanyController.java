package com.gabriel.andrade.company_supplier.controller;

import com.gabriel.andrade.company_supplier.dto.CompanyDTO;
import com.gabriel.andrade.company_supplier.entity.CompanyEntity;
import com.gabriel.andrade.company_supplier.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<CompanyEntity>> findAllCompany(){
        return ResponseEntity.ok(companyService.findCompanys());
    }

    @GetMapping("/find")
    public ResponseEntity<List<CompanyEntity>> findCompanyByCnpj(@RequestParam(name = "cnpj", required = false) String cnpj,
                                                                 @RequestParam(name = "name", required = false) String name){
        CompanyDTO companyDTO = new CompanyDTO();
        if (Objects.nonNull(name) && Objects.isNull(cnpj)){
            companyDTO.setFantasyName(name);
            return ResponseEntity.ok(companyService.findCompanyByCnpj(companyDTO));
        } else if (Objects.nonNull(cnpj) && Objects.isNull(name)) {
            companyDTO.setCnpj(cnpj);
            return ResponseEntity.ok(companyService.findCompanyByCnpj(companyDTO));
        }
        return null;
    }

    @PostMapping
    public ResponseEntity saveCompany(@RequestBody CompanyDTO companyDTO){
        companyService.saveCompany(companyDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity deletCompany(@Valid @PathVariable String cnpj){
        companyService.deletCompany(cnpj);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateCompany(@RequestBody CompanyDTO companyDTO){
        companyService.updateCompany(companyDTO);
        return ResponseEntity.ok().build();
    }



}
