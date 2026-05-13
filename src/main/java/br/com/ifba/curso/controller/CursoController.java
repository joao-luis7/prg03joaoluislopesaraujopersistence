/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoService;
import br.com.ifba.curso.service.CursoIService;
import java.util.List;
/**
 *
 * @author joaol
 */
public class CursoController implements CursoIController{
    private final CursoIService cursoService;

    public CursoController() {
        this.cursoService = new CursoService();
    }

    //Inclui um novo curso.
    @Override
    public String incluir(Curso curso) {
        return cursoService.save(curso);
    }

    //Atualiza um curso existente.
    @Override
    public String atualizar(Curso curso) {
        return cursoService.update(curso);
    }

    //Remove um curso pelo seu ID.
    @Override
    public String deletar(Long id) {
        return cursoService.delete(id);
    }

    //Lista todos os cursos cadastrados.
    @Override
    public List<Curso> listar() {
        return cursoService.findAll();
    }

    //Busca um curso pelo seu ID.
    @Override
    public Curso buscarPorId(Long id) {
        return cursoService.findById(id);
    }

    //Busca cursos por nome.
    @Override
    public List<Curso> buscarPorNome(String nome) {
        return cursoService.findByNome(nome);
    }
    
}
