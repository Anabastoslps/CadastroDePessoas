package com.cadastrodepessoas.demo.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cadastrodepessoas.demo.Models.Pessoa;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
