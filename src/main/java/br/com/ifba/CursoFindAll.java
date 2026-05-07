/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba;

import br.com.ifba.curso.entity.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author joaol
 */
public class CursoFindAll {
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("gerenciamento-cursos");
    
    public List<Curso> listarTodos() throws RuntimeException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // Cria a consulta usando JPQL (Java Persistence Query Language).
            // A consulta "SELECT c FROM Curso c" significa:
            // "Selecione todos os objetos 'c' onde 'c' é uma entidade do tipo Curso".
            // Note que "Curso" é o nome da sua classe @Entity, não o nome da tabela no SQL.
            List<Curso> cursos = entityManager.createQuery("SELECT c FROM Curso c", Curso.class)
                                              .getResultList();
            
            // 2. Retorna a lista de cursos encontrados.
            return cursos;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar todos os cursos: " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}

