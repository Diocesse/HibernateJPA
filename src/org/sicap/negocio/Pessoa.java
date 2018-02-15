/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sicap.negocio;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author leandro
 */
@Entity
@Table(name = "tbl_pessoa")
public class Pessoa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Pessoa",nullable = false)
    private long idPessoa;
    @Column(name = "nome",nullable = false)
    private String nome;
    @Column(name = "email",nullable = false, unique = true)
    private String email;
    @OneToMany(mappedBy = "pessoas")
    private Collection<Servico> servicos = new ArrayDeque<>() ;

    public long getIdPessoa() {
        return idPessoa;
    }

    public Collection<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(Collection<Servico> servicos) {
        this.servicos = servicos;
    }

    public void setIdPessoa(long idPessoa) {
        this.idPessoa = idPessoa;
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
    
    
}
