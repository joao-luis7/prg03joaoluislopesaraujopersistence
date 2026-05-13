/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.util.StringUtil;
import java.util.List;
/**
 *
 * @author joaol
 */
public class CursoService implements CursoIService{
    private final CursoIDao cursoDao;

    public CursoService() {
        this.cursoDao = new CursoDao();
    }

    // Salva um novo curso aplicando regras de negócio.
    @Override
    public String save(Curso curso) {
        // Validação de regra de negócio: curso não pode ser nulo
        if (curso == null) {
            return "Erro: O curso não pode ser nulo.";
        }

        // Validação de regra de negócio: código é obrigatório
        if (StringUtil.isBlank(curso.getCodigo())) {
            return "Erro: O código do curso é obrigatório.";
        }

        // Validação de regra de negócio: nome é obrigatório
        if (StringUtil.isBlank(curso.getNome())) {
            return "Erro: O nome do curso é obrigatório.";
        }

        // Validação de regra de negócio: carga horária deve ser positiva
        if (curso.getCargaHoraria() <= 0) {
            return "Erro: A carga horária deve ser maior que zero.";
        }

        // Se passou por todas as validações, chama o DAO para persistir
        try {
            cursoDao.save(curso);
            return "Curso salvo com sucesso!";
        } catch (Exception e) {
            return "Erro ao salvar curso: " + e.getMessage();
        }
    }

    /**
     * Atualiza um curso existente aplicando regras de negócio.
     * Valida se os campos obrigatórios estão preenchidos antes de chamar o DAO.
     */
    @Override
    public String update(Curso curso) {
        // Validação de regra de negócio: curso não pode ser nulo
        if (curso == null) {
            return "Erro: O curso não pode ser nulo.";
        }

        // Validação de regra de negócio: ID deve existir
        if (curso.getId() == null) {
            return "Erro: O ID do curso é obrigatório para atualização.";
        }

        // Validação de regra de negócio: código é obrigatório
        if (StringUtil.isBlank(curso.getCodigo())) {
            return "Erro: O código do curso é obrigatório.";
        }

        // Validação de regra de negócio: nome é obrigatório
        if (StringUtil.isBlank(curso.getNome())) {
            return "Erro: O nome do curso é obrigatório.";
        }

        // Validação de regra de negócio: carga horária deve ser positiva
        if (curso.getCargaHoraria() <= 0) {
            return "Erro: A carga horária deve ser maior que zero.";
        }

        // Se passou por todas as validações, chama o DAO para atualizar
        try {
            cursoDao.update(curso);
            return "Curso atualizado com sucesso!";
        } catch (Exception e) {
            return "Erro ao atualizar curso: " + e.getMessage();
        }
    }

    // Remove um curso pelo seu ID.
    @Override
    public String delete(Long id) {
        // Validação de regra de negócio: ID não pode ser nulo
        if (id == null) {
            return "Erro: O ID não pode ser nulo.";
        }

        // Se passou pelas validações, chama o DAO para remover
        try {
            cursoDao.delete(id);
            return "Curso removido com sucesso!";
        } catch (Exception e) {
            return "Erro ao remover curso: " + e.getMessage();
        }
    }

    // Lista todos os cursos cadastrados.
    @Override
    public List<Curso> findAll() {
        try {
            return cursoDao.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar cursos: " + e.getMessage(), e);
        }
    }

    // Busca um curso pelo seu ID.
    @Override
    public Curso findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo.");
        }
        try {
            return cursoDao.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar curso por ID: " + e.getMessage(), e);
        }
    }

    // Busca cursos por nome (parcial, case-insensitive).
    @Override
    public List<Curso> findByNome(String nome) {
        // Validação de regra de negócio: nome não pode ser vazio para busca
        if (StringUtil.isBlank(nome)) {
            throw new IllegalArgumentException("Nome para busca não pode ser vazio.");
        }

        try {
            return cursoDao.findByNome(nome);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar curso por nome: " + e.getMessage(), e);
        }
    }
}
