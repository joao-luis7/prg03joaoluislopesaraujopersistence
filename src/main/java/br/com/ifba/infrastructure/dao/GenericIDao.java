/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import java.util.List;

/**
 * Interface genérica para operações de CRUD.
 * Define os métodos básicos que qualquer DAO deve implementar.
 * @author joaol
 * @param <T> Tipo da entidade
 * @param <ID> Tipo do identificador da entidade
 */
public interface GenericIDao<T, ID> {

    /**
     * Salva uma nova entidade no banco de dados.
     * @param entity Entidade a ser salva
     * @return Entidade salva
     */
    T save(T entity);

    /**
     * Atualiza uma entidade existente no banco de dados.
     * @param entity Entidade a ser atualizada
     * @return Entidade atualizada
     */
    T update(T entity);

    /**
     * Remove uma entidade do banco de dados pelo seu ID.
     * @param id ID da entidade a ser removida
     */
    void delete(ID id);

    /**
     * Busca uma entidade pelo seu ID.
     * @param id ID da entidade a ser buscada
     * @return Entidade encontrada ou null se não existir
     */
    T findById(ID id);

    /**
     * Lista todas as entidades do tipo T.
     * @return Lista com todas as entidades
     */
    List<T> findAll();
}