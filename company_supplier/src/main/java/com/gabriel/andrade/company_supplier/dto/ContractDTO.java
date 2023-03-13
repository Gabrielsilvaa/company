package com.gabriel.andrade.company_supplier.dto;

import com.gabriel.andrade.company_supplier.entity.CompanyEntity;
import com.gabriel.andrade.company_supplier.entity.SupplierEntity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractDTO {
    private CompanyEntity idCompany;

    private String companyName;

    private SupplierEntity idSupplier;

    private String supplierName;

    private String status;

    private Long id;
}
