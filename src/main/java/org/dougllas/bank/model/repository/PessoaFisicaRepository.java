package org.dougllas.bank.model.repository;

import org.dougllas.bank.model.entity.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaFisicaRepository  extends JpaRepository<PessoaFisica, Integer> {

    Optional<PessoaFisica> findByCpf( String cpf );
}