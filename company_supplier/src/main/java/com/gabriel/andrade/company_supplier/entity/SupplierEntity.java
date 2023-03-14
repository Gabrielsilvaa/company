package com.gabriel.andrade.company_supplier.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CNPJ
    @Column(name = "CNJP")
    private String cnpj;

    @CPF
    @Column(name = "CPF")
    private String cpf;

    @NotEmpty(message = "name can't be null")
    private String name;

    @NotEmpty(message = "email can't be null")
    private String email;

    @NotEmpty(message = "CEP can't be null")
    private String cep;

    private String rg;

    private LocalDate dateOfBirth;

}
