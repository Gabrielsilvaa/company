package com.gabriel.andrade.company_supplier.client;

import com.gabriel.andrade.company_supplier.dto.CepLaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://cep.la", name = "cepla")
public interface CepLaClient {

    @GetMapping(value = "/{cep}", produces = MediaType.APPLICATION_JSON_VALUE)
    CepLaDTO searchByZipCode(@PathVariable("cep") String cep);

}
