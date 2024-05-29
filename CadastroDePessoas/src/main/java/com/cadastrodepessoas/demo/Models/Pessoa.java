package com.cadastrodepessoas.demo.Models;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false, unique = true)
    private Long idPessoaModels;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;
    //nullable especifica que nao pode ter valor null(nulo), logo é necessario ter um valor

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column
    private String senha;

    public Pessoa() {

    }

    public Long getId() {
        return idPessoaModels;
    }

    public void setId(Long id) {
        this.idPessoaModels = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getIdPessoaModels() {
        return idPessoaModels;
    }

    public void setIdPessoaModels(Long idPessoaModels) {
        this.idPessoaModels = idPessoaModels;
    }


}
