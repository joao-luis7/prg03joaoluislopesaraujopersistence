/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba;

import br.com.ifba.curso.entity.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;
/**
 *
 * @author joaol
 */
public class CursoUpdate {
    
   private final EntityManagerFactory entityManagerFactory = 
            Persistence.createEntityManagerFactory("gerenciamento-cursos");
      
   public Curso atualizar(Curso curso){
       //validacao
       if (curso == null){
           throw new IllegalArgumentException("Curso nao pode ser nulo");
       }
       
       EntityManager entityManager = null;
       try{
           entityManager = entityManagerFactory.createEntityManager();
           entityManager.getTransaction().begin();
           
           //merge insere se nao existe, atualiza se existir
           Curso cursoAtualizado = entityManager.merge(curso);
           
           entityManager.getTransaction().commit();
           
           return cursoAtualizado;
       } catch(IllegalArgumentException e){
           throw e;
       } catch(Exception e){
           //em caso de erro faz rollback da transacao
           if (entityManager != null && entityManager.getTransaction().isActive()){
               entityManager.getTransaction().rollback();
           }
           throw new RuntimeException("Erro ao atualizar o curso: " + e.getMessage(), e);
       } finally {
           //limpeza
           if(entityManager != null && entityManager.isOpen()){
               entityManager.close();
           }
       }
   }
}
