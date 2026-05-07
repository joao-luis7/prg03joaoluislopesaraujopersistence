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
public class CursoDelete {
    
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("gerenciamento-cursos");
    
    public void remover(Long id){
        //validacao de id
        if (id == null || id < 0){
            throw new IllegalArgumentException("ID invalido");
        }
        
        EntityManager entityManager = null;
        try{
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            
            //sempre buscar antes de remover
            Curso curso = entityManager.find(Curso.class, id);
            
            if(curso == null){
                throw new IllegalArgumentException("Curso com ID: " + id + " não encontrado");
            }
            
            //remove o curso do banco
            entityManager.remove(curso);
            
            entityManager.getTransaction().commit();
        } catch (IllegalArgumentException e){
            //lanca excecoes de validacao
            throw e;
        } catch (Exception e){
            //em caso de erro, faz rolback da transacao
            if(entityManager != null && entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao remover curso " + e.getMessage(), e);
        } finally{
            if(entityManager != null && entityManager.isOpen()){
                entityManager.close();
            }
        }
    }
}
