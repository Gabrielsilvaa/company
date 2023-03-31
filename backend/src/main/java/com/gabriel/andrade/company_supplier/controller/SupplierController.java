package com.gabriel.andrade.company_supplier.controller;

import com.gabriel.andrade.company_supplier.dto.SupplierDTO;
import com.gabriel.andrade.company_supplier.entity.SupplierEntity;
import com.gabriel.andrade.company_supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<SupplierEntity>> findAllService(){
        return ResponseEntity.ok(supplierService.findSuppliers());
    }

    @GetMapping("/supplier")
    public ResponseEntity<List<SupplierEntity>> findServiceByDocument(
            @RequestParam(name = "documentNumber", required = false) String documentNumber,
            @RequestParam(name = "name", required = false) String name
    ){
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setDocumentNumber(documentNumber);
        supplierDTO.setName(name);
        return ResponseEntity.ok(supplierService.findSupplier(supplierDTO));
    }

    @PostMapping
    public ResponseEntity saveSupplier(@RequestBody SupplierDTO supplierDTO){
        supplierService.saveSupplier(supplierDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deletSupplier(@RequestBody SupplierDTO supplierDTO){
        supplierService.deletSupplier(supplierDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateSupplier(@RequestBody SupplierDTO supplierDTO){
        supplierService.updateSupplier(supplierDTO);
        return ResponseEntity.ok().build();
    }

}
