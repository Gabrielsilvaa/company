package com.gabriel.andrade.company_supplier.dto;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {

    @CNPJ(message = "CNPJ invalido")
    @NotEmpty(message = "CNPJ can't be null")
    private String cnpj;

    @NotEmpty(message = "fantasy Name can't be null")
    private String fantasyName;

    @NotEmpty(message = "CEP can't be null")
    private String cep;

}
