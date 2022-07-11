package com.sigabem.frete.controller;

import com.sigabem.frete.model.Frete;
import com.sigabem.frete.model.FreteDTO;
import com.sigabem.frete.model.ViaCepDTO;
import com.sigabem.frete.repository.FreteRepository;
import com.sigabem.frete.service.ConsumerViaCepService;
import com.sigabem.frete.service.FreteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FreteController {

  @Autowired
  FreteService freteService;

  @PostMapping("/frete")
  public ResponseEntity<Frete> calcularFrete(@RequestBody FreteDTO freteDTO){
    Frete frete = new Frete();
    BeanUtils.copyProperties(freteDTO, frete);
    freteService.calcularPreco(frete);
    freteService.calcularPrazo(frete);
    return ResponseEntity.status(HttpStatus.OK).body(freteService.save(frete));
  }
}
