package com.sigabem.frete.model;

import lombok.Data;

@Data
public class FreteDTO {
    private String nomeDestinatario;
    private String cepOrigem;
    private String cepDestino;
    private Double peso;
}
