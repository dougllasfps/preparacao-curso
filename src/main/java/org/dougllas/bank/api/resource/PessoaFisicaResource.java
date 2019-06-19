package org.dougllas.bank.api.resource;

import lombok.AllArgsConstructor;
import org.dougllas.bank.api.resource.dto.PessoaFisicaDTO;
import org.dougllas.bank.api.resource.response.BadRequestResponseEntity;
import org.dougllas.bank.model.entity.PessoaFisica;
import org.dougllas.bank.service.PessoaFisicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/pessoasfisicas")
@AllArgsConstructor
public class PessoaFisicaResource {

    private final PessoaFisicaService service;

    @GetMapping("{cpf}")
    public PessoaFisicaDTO obterPorCpf( @PathVariable("cpf") String cpf ){
        return service
                    .obterPorCpf(cpf)
                    .map( p -> PessoaFisicaDTO.builder().cpf(p.getCpf()).nome(p.getNome()).build())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody @Valid PessoaFisicaDTO dto, BindingResult result){
        if(result.hasErrors()){
            return new BadRequestResponseEntity(result);
        }
        PessoaFisica pessoaFisica = converter(dto);
        service.save(pessoaFisica);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizar( @PathVariable("id") Integer id, @RequestBody @Valid PessoaFisicaDTO dto, BindingResult result){
        if(result.hasErrors()){
            return new BadRequestResponseEntity(result);
        }

        return service.obterPorId(id).map( pf -> {
            pf.setCpf(dto.getCpf());
            pf.setNome(dto.getCpf());
            service.save( pf );
            return ResponseEntity.ok( converter(pf) );
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    public ResponseEntity deletar( @PathVariable("id") Integer id){
        return service.obterPorId(id).map( pf -> {
            service.delete(pf);
            return ResponseEntity.ok( converter(pf) );
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private PessoaFisicaDTO converter(PessoaFisica entity){
        return Optional
                .ofNullable(entity)
                .map( p -> PessoaFisicaDTO.builder().cpf(p.getCpf()).nome(p.getNome()).build())
                .orElse(null);
    }

    private PessoaFisica converter(PessoaFisicaDTO dto){
        return Optional
                .ofNullable(dto)
                .map( p -> PessoaFisica.builder().cpf(p.getCpf()).nome(p.getNome()).build())
                .orElse(null);
    }
}
