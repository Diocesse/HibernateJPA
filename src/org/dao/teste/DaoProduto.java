/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao.teste;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;
import org.sicap.negocio.Pessoa;
import org.sicap.negocio.Servico;

public class DaoProduto implements Serializable {

    public static void main(String[] args) throws ParseException {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJPAPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Pessoa p = new Pessoa();
        p.setNome("Leandro de Souza");
        p.setEmail("diocesse@gmail.com");
        Servico s = new Servico();
        s.setDataHoradoServico(Calendar.getInstance().getTime());
        p.getServicos().add(s);
        s.getPessoas().add(p);
        em.persist(s);
        em.persist(p);
        em.getTransaction().commit();
        emf.close();
       // Query q = em.createQuery("SELECT s FROM Servico s");
       // List<Servico> lista = q.getResultList();
       

    }

}
