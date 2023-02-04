package com.aulaspring.aula.resources;

import com.aulaspring.aula.entities.Aluno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/m1s05")
public class AlunoController {

    private ArrayList<Aluno> alunos = new ArrayList<>();

    @GetMapping(value = "/ex4/aluno/{matricula}")  //ok
    public ResponseEntity<Aluno> listarAluno(@PathVariable Long matricula){
        //consultar no objeto a matricula e retornar o primeiro registro
        Aluno a = alunos.stream().filter(Aluno -> matricula.equals(Aluno.getMatricula())).findFirst().get();
        return ResponseEntity.ok().body(a);
    }


    @PostMapping(value = "/ex4/aluno") //ok
    public ResponseEntity<Aluno> incluirAluno(@RequestBody Aluno aluno) {
        this.alunos.add(aluno);
        return ResponseEntity.created(URI.create("")).body(aluno);
    }

    @GetMapping(value = "/ex4/aluno") //ok
    public List<Aluno> listar() {
        List<Aluno> listaAlunos = this.alunos;
        return ResponseEntity.ok().body(listaAlunos).getBody();
    }

    @PutMapping(value = "/ex4/aluno") //ok
    public ResponseEntity<Aluno> alterar(@RequestParam(value = "matricula") Long matricula,
                                         @RequestParam(value = "nome") String nome) {
        //buscando o aluno
        Aluno a = alunos.stream().filter(Aluno -> matricula.equals
                (Aluno.getMatricula())).findFirst().get();
        //setando o aluno
        a.setNome(nome);
        //retorno
        return ResponseEntity.ok().body(a);
    }

    @DeleteMapping("/ex4/aluno/{matricula}") //ok
    public ResponseEntity<Aluno>  deletar(@PathVariable Long matricula){
        Aluno a = alunos.stream().filter(Aluno -> matricula.equals
                (Aluno.getMatricula())).findFirst().get();
        alunos.remove(a);

        //retorno
        return ResponseEntity.ok().body(a);
    }

}
