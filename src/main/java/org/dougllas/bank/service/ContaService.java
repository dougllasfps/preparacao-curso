package org.dougllas.bank.service;

import org.dougllas.bank.model.entity.Conta;
import java.util.Optional;

public interface ContaService {

    Optional<Conta> acharPorNumeroEDigito( Integer numero, Integer digito );

    Conta salvar( Conta conta );

    void validar( Conta conta );

}
