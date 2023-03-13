package com.gabriel.andrade.company_supplier.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {

    @CNPJ
    private String cnpj;

    @CPF
    private String cpf;

    @NotEmpty(message = "name can't be null")
    private String name;

    @NotEmpty(message = "email can't be null")
    private String email;

    @NotEmpty(message = "CEP can't be null")
    private String cep;

    private String rg;

    private String dateOfBirth;
}
