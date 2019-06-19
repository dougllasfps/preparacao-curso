package org.dougllas.bank.service;

import org.dougllas.bank.model.entity.PessoaFisica;

import java.util.Optional;

public interface PessoaFisicaService {

    Optional<PessoaFisica> obterPorId(Integer id);

    Optional<PessoaFisica> obterPorCpf(String cpf);

    PessoaFisica save(PessoaFisica p);

    void delete(PessoaFisica pf);
}