package com.sigabem.frete.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class Frete {
  @Id private String id;
  private String nomeDestinatario;
  private String cepOrigem;
  private String cepDestino;
  private Double peso;
  private Double vlTotalFrete;
  private LocalDate dataPrevistaEntrega;
  private LocalDate dataConsulta;
}
