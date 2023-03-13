package com.gabriel.andrade.company_supplier.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContract;

    @ManyToOne
    private CompanyEntity idCompany;

    private String companyName;

    @ManyToOne
    private SupplierEntity idSupplier;

    private String supplierName;

    private String status;

}
