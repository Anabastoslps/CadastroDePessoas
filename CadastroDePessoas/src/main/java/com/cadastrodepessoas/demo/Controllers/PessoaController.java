package com.cadastrodepessoas.demo.Controllers;

import com.cadastrodepessoas.demo.Models.Pessoa;
import com.cadastrodepessoas.demo.repositores.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController //vai lidar com solicitações HTTP e retornar respostas HTTP, geralmente em formato JSON.
@RequestMapping("/pessoa")// o método de controle correspondente é invocado para processar a solicitação
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{id}")//mapeia requisição HTTP
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id){
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        if (optionalPessoa.isPresent()) {
            return ResponseEntity.ok(optionalPessoa.get());
        } else {
           return ResponseEntity.notFound().build();
           //se pessoa nao for encontrada retorna 404 (not fund)
        }
    }

    @PostMapping ResponseEntity<Pessoa> createPessoa(@RequestBody  Pessoa pessoa){
        Pessoa createdPessoa = pessoaRepository.save(pessoa);
        return ResponseEntity.ok(createdPessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa dadosRequest) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        if (optionalPessoa.isPresent()) {
            Pessoa pessoa = optionalPessoa.get();
            Pessoa updatePessoa = pessoaRepository.save(pessoa);
            return ResponseEntity.ok(updatePessoa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id){
            Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
            if (optionalPessoa.isPresent()) {
                pessoaRepository.delete(optionalPessoa.get());
                return ResponseEntity.noContent().build();
            }else {
                return ResponseEntity.notFound().build();
            }
    }


}





