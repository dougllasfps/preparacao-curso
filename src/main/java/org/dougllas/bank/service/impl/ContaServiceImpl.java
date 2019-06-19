package org.dougllas.bank.service.impl;

import lombok.AllArgsConstructor;
import org.dougllas.bank.model.repository.ContaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContaServiceImpl {

    private final ContaRepository repository;
}
