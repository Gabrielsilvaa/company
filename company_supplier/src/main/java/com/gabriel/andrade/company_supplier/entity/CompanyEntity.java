package com.gabriel.andrade.company_supplier.entity;

import com.gabriel.andrade.company_supplier.dto.SupplierDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Getter
@Setter
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompany;

    @CNPJ
    @NotEmpty(message = "CNPJ can't be null")
    @Column(name = "CNJP")
    private String cnpj;

    @NotEmpty(message = "fantasy Name can't be null")
    private String fantasyName;

    @NotEmpty(message = "CEP can't be null")
    private String cep;

}
