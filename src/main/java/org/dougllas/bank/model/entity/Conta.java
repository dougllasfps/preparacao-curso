package org.dougllas.bank.model.entity;

import lombok.Data;
import org.dougllas.bank.model.enums.TipoConta;
import javax.persistence.*;

@Entity
@Table
@Data
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_titular")
    private PessoaFisica titular;

    @Column
    private Integer numero;

    @Column
    private Integer digito;

    @Enumerated(value = EnumType.STRING)
    private TipoConta tipo;

    @Column
    private String senha;

}
