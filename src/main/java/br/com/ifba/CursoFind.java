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
public class CursoFind {
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("gerenciamento-cursos");

    /**
     * Busca cursos cujo nome contenha o texto fornecido.
     * A busca não diferencia maiúsculas de minúsculas e encontra o texto em qualquer parte do nome.
     * @param nome O texto a ser procurado no nome dos cursos.
     * @return Uma lista de objetos Curso que correspondem ao critério de busca.
     */
    public List<Curso> buscarPorNome(String nome) {

        // Validação de entrada 
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio para busca.");
        }

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin(); // ← Transação explícita

            String jpql = "SELECT c FROM Curso c WHERE LOWER(c.nome) LIKE LOWER(:nomeBusca)";
            TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
            query.setParameter("nomeBusca", "%" + nome.trim() + "%");

            List<Curso> resultados = query.getResultList();

            entityManager.getTransaction().commit(); 
            return resultados;

        } catch (Exception e) {
            entityManager.getTransaction().rollback(); //desfaz em caso de erro
            // Sinaliza o erro para quem chamou (sem esconder o tipo original)
            throw e;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // ← Libera recurso 
            }
        }
    }
}
