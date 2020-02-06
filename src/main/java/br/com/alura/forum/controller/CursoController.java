package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.CursoDto;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.repository.CursoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<CursoDto> listaCursos (){

        List<Curso> cursos = cursoRepository.findAll();

        return new CursoDto().converter(cursos);
    }


}
