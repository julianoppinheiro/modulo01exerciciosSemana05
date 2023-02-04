package com.aulaspring.aula.resources;

import com.aulaspring.aula.entities.Aluno;
import com.aulaspring.aula.servicos.Validador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/m1s05")
public class PrincipalController {

    private Validador validador;
    //exercicio 01, validador de CPF
    @GetMapping ("/ex1/cpf") //ok
    public ResponseEntity<Boolean> validarCPF(@RequestParam("cpf") String cpf){
        //Mostrar mensagem de validação personalizada
        //Boolean resultado = true;
        boolean resultado = Validador.verificarCpf(cpf);
        return ResponseEntity.ok().body(resultado);
    }

    //exercicio 01, validador de CPF
    @GetMapping ("/ex1/cnpj") //ok
    public ResponseEntity<Boolean> validarCNPJ(@RequestParam("cnpj") String cnpj) {
        //Mostrar mensagem de validação personalizada
        Boolean resultado = Validador.verificarCnpj(cnpj);
        return ResponseEntity.ok().body(resultado);
    }

    //exercicio 02, calcular a média de notas
    @GetMapping(value = "/ex2/calcularmedia")  //ok
    public ResponseEntity <Double> calcularMedia(@RequestParam("nota1") Double nota1, @RequestParam("nota2") Double nota2, @RequestParam("nota3") Double nota3){
        Double media = (nota1 + nota2 + nota3) / 3;
        //retornar a media
        return ResponseEntity.ok().body(media);
    }

    //exercicio 03, instanciado o Aluno oara o Post
    private ArrayList<Aluno> alunos = new ArrayList<>();

    @PostMapping(value = "/ex3/aluno") //ok

    public ResponseEntity<ArrayList<Aluno>> incluirV2(@RequestParam(value = "matricula") Long matricula,
                                                      @RequestParam(value = "nome") String nome ){
        this.alunos.add(new Aluno(matricula, nome));

        return ResponseEntity.created(URI.create("")).body(this.alunos);

    }

}
