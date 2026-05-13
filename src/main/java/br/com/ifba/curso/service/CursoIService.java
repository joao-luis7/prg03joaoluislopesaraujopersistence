/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import java.util.List;
/**
 *
 * @author joaol
 */
public interface CursoIService{
    
    //Salva um novo curso aplicando regras de negócio.
    String save(Curso curso);

    //Atualiza um curso existente aplicando regras de negócio.
    String update(Curso curso);

    //Remove um curso pelo seu ID.
    String delete(Long id);

    // Lista todos os cursos cadastrados.
    List<Curso> findAll();

    //Busca um curso pelo seu ID.
    Curso findById(Long id);

    //Busca cursos por nome (parcial, case-insensitive).
    List<Curso> findByNome(String nome);
}
