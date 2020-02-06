package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Curso;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CursoDto {



    private Long id;
    private String nome;
    private String categoria;

    public CursoDto(Long id, String nome, String categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    public CursoDto() {
    }

    public static List<CursoDto> converter(List<Curso> cursos) {

        List<CursoDto> cursoDtos = new ArrayList<>();
        for (Curso curso:cursos) {
            CursoDto dto = new CursoDto(curso.getId(), curso.getNome(), curso.getCategoria());
            cursoDtos.add(dto);
        }
        return cursoDtos;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }


}
