package com.gabriel.andrade.company_supplier.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CepLaDTO {
    private String cep;
    private String uf;

    private String cidade;

    private String bairro;

    private String logradouro;
}
