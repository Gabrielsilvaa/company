package com.gabriel.andrade.company_supplier.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {

    private String documentNumber;

    @NotEmpty(message = "typeDocument can't be null")
    private String typeDocument;

    @NotEmpty(message = "name can't be null")
    private String name;

    @NotEmpty(message = "email can't be null")
    private String email;

    @NotEmpty(message = "CEP can't be null")
    private String cep;

    private String rg;

    private LocalDate dateOfBirth;
}
