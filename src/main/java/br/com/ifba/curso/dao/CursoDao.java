/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * Implementação especifica do DAO para a entidade Curso.
 * Herda todas as operações CRUD do GenericDao.
 * @author joaol
 */
public class CursoDao extends GenericDao<Curso, Long> implements CursoIDao {

    public CursoDao() {
        super(Curso.class);
    }

    @Override
    public List<Curso> findByNome(String nome) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Curso> resultados;

        try {
            // JPQL: Seleciona c onde o nome de c contém o parâmetro :nome (case-insensitive)
            String jpql = "SELECT c FROM Curso c WHERE LOWER(c.nome) LIKE LOWER(:nome)";
            
            TypedQuery<Curso> query = em.createQuery(jpql, Curso.class);
            
            // O % é o curinga do SQL. Adicionamos antes e depois para buscar "contém"
            query.setParameter("nome", "%" + nome + "%");
            
            resultados = query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar curso por nome: " + e.getMessage(), e);
        } finally {
            // O GenericDao geralmente gerencia o fechamento, mas se sua implementação 
            // exigir fechamento manual aqui, faça-o. Se o getEntityManager() abrir um novo,
            // precisamos fechar. Assumindo que segue o padrão do seu GenericDao:
            if (em != null && em.isOpen()) {
               // em.close(); // Descomente apenas se o seu GenericDao NÃO gerenciar o fechamento nesta chamada
            }
        }
        
        return resultados;
    }
}