package com.sigabem.frete.service;

import com.sigabem.frete.model.Frete;
import com.sigabem.frete.model.ViaCepDTO;
import com.sigabem.frete.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FreteService {
    @Autowired
    ConsumerViaCepService consumerViaCepService;
    @Autowired
    FreteRepository freteRepository;

    public Frete calcularPrazo(Frete frete) {
        ViaCepDTO responseCepOrigem = consumerViaCepService.getInfoPorCep(frete.getCepOrigem());
        ViaCepDTO responseCepDestino = consumerViaCepService.getInfoPorCep(frete.getCepDestino());
        frete.setDataConsulta(LocalDate.now());

        if (responseCepOrigem.getDdd().equals(responseCepDestino.getDdd())) {
            frete.setDataPrevistaEntrega(LocalDate.now().plusDays(1));
            return frete;
        }

        if (responseCepOrigem.getUf().equals(responseCepDestino.getUf())) {
            frete.setDataPrevistaEntrega(LocalDate.now().plusDays(3));
            return frete;
        }

        if (!responseCepOrigem.getUf().equals(responseCepDestino.getUf())) {
            frete.setDataPrevistaEntrega(LocalDate.now().plusDays(10));
            return frete;
        }
        return frete;
    }

    public Frete calcularPreco(Frete frete) {
        ViaCepDTO responseCepOrigem = consumerViaCepService.getInfoPorCep(frete.getCepOrigem());
        ViaCepDTO responseCepDestino = consumerViaCepService.getInfoPorCep(frete.getCepDestino());

        if (responseCepOrigem.getDdd().equals(responseCepDestino.getDdd())) {
            frete.setVlTotalFrete(frete.getPeso() - (frete.getPeso() * 0.50));
            return frete;
        }

        if (responseCepOrigem.getUf().equals(responseCepDestino.getUf())) {
            frete.setVlTotalFrete(frete.getPeso() - (frete.getPeso() * 0.75));
            return frete;
        }

        if (!responseCepOrigem.getUf().equals(responseCepDestino.getUf())) {
            frete.setVlTotalFrete(frete.getPeso());
            return frete;
        }

        return frete;
    }

    public Frete save(Frete frete) {
        return freteRepository.save(frete);
    }
}
