/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import java.util.List;
/**
 *
 * @author joaol
 */
public interface CursoIController {
      /**
     * Inclui um novo curso.
     * @param curso Curso a ser incluído
     * @return Mensagem de resultado da operação
     */
    String incluir(Curso curso);

    /**
     * Atualiza um curso existente.
     * @param curso Curso a ser atualizado
     * @return Mensagem de resultado da operação
     */
    String atualizar(Curso curso);

    /**
     * Remove um curso pelo seu ID.
     * @param id ID do curso a ser removido
     * @return Mensagem de resultado da operação
     */
    String deletar(Long id);

    /**
     * Lista todos os cursos cadastrados.
     * @return Lista de cursos
     */
    List<Curso> listar();

    /**
     * Busca um curso pelo seu ID.
     * @param id ID do curso a ser buscado
     * @return Curso encontrado ou null se não existir
     */
    Curso buscarPorId(Long id);

    /**
     * Busca cursos por nome.
     * @param nome Nome ou parte do nome do curso
     * @return Lista de cursos encontrados
     */
    List<Curso> buscarPorNome(String nome);
}
