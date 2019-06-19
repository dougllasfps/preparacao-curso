package org.dougllas.bank.model.repository;

import org.dougllas.bank.model.entity.Conta;
import org.dougllas.bank.model.entity.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

    List<Conta> findByTitular(PessoaFisica pessoaFisica);

}
