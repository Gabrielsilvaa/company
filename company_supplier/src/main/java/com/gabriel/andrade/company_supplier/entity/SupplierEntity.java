package com.gabriel.andrade.company_supplier.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Getter
@Setter
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

}
