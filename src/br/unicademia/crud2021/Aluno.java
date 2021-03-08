/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicademia.crud2021;

import java.util.Date;

/**
 *
 * @author chris
 */
public class Aluno {
    
        private int id;
	private String nome;
	private Date dataMatricula;
	private String endereco;
	private String telefone;
	private Date dataNascimento;
	private Float altura;
	private Float peso;

    public Aluno() {
    }
       
    public Aluno(int id, String nome, Date dataMatricula, String endereco, String telefone, Date dataNascimento, Float altura, Float peso) {
        this.id = id;
        this.nome = nome;
        this.dataMatricula = dataMatricula;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
        this.peso = peso;
    }
        
        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", nome=" + nome + ", dataMatricula=" + dataMatricula + ", endereco=" + endereco + ", telefone=" + telefone + ", dataNascimento=" + dataNascimento + ", altura=" + altura + ", peso=" + peso + '}';
    }
        
    
}
