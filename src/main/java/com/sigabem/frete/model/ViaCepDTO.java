package com.sigabem.frete.model;


import lombok.Data;

@Data
public class ViaCepDTO {
    private String localidade;
    private String cep;
    private String uf;
    private String ddd;
}
