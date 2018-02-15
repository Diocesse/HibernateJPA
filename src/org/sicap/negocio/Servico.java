/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sicap.negocio;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author leandro
 */
@Entity
@Table(name = "tbl_servico")
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServico;

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public Long getIdServico() {
        return idServico;
    }

    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "dhservico")
    private Date dataHoradoServico;
    @ManyToMany
    @JoinTable(name = "pessoas_servicos", joinColumns = @JoinColumn(name = "idServico")
    ,inverseJoinColumns = @JoinColumn(name = "idPessoa"))
     private Collection<Pessoa> pessoas = new ArrayDeque<>()
            ;
    

    public Date getDataHoradoServico() {
        return dataHoradoServico;
    }

    public void setDataHoradoServico(Date dataHoradoServico) {
        this.dataHoradoServico = dataHoradoServico;
    }

    public void setPessoas(Collection<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Collection<Pessoa> getPessoas() {
        return pessoas;
    }

      
    
    
    
}
