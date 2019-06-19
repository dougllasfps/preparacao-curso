package org.dougllas.bank.api.resource.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class PessoaFisicaDTO {

    @NotEmpty(message = "Campo nome é obrigatório.")
    private String nome;

    @NotEmpty
    @CPF(message = "CPF inválido.")
    private String cpf;
}
