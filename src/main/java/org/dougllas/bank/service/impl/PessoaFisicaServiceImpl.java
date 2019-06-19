package org.dougllas.bank.service.impl;

import lombok.AllArgsConstructor;
import org.dougllas.bank.model.entity.PessoaFisica;
import org.dougllas.bank.model.repository.PessoaFisicaRepository;
import org.dougllas.bank.service.PessoaFisicaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PessoaFisicaServiceImpl implements PessoaFisicaService {

    private final PessoaFisicaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Optional<PessoaFisica> obterPorId(Integer id) {
        return Optional.ofNullable(id).map( i -> repository.findById(i) ).orElse(Optional.empty());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PessoaFisica> obterPorCpf(String cpf) {
        return Optional.ofNullable(cpf).map( s -> repository.findByCpf(s) ).orElse(Optional.empty());
    }

    @Override
    @Transactional
    public PessoaFisica save(PessoaFisica p) {
        return Optional.ofNullable(p)
                    .map( pessoa -> repository.save(pessoa) )
                .orElseThrow(() -> new IllegalArgumentException("Não é possível salvar entidade nula"));
    }

    @Override
    @Transactional
    public void delete(PessoaFisica pf) {
        Optional.ofNullable(pf).map( p -> p.getId() ).ifPresent(id -> repository.delete(pf));
    }
}
