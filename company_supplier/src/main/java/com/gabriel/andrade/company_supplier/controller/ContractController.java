package com.gabriel.andrade.company_supplier.controller;

import com.gabriel.andrade.company_supplier.dto.ContractDTO;
import com.gabriel.andrade.company_supplier.dto.SupplierDTO;
import com.gabriel.andrade.company_supplier.entity.CompanyEntity;
import com.gabriel.andrade.company_supplier.entity.ContractEntity;
import com.gabriel.andrade.company_supplier.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    ContractService contractService;

    @GetMapping
    public ResponseEntity<List<ContractEntity>> findAllContract(){
        return ResponseEntity.ok(contractService.contracts());
    }

    @PutMapping
    public ResponseEntity updateContract(@RequestBody ContractDTO contractDTO){
        contractService.updateContract(contractDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity saveContract(@RequestBody ContractDTO contractDTO){
        contractService.createContract(contractDTO);
        return ResponseEntity.ok().build();
    }

}
