package com.cripto;
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Teste {

    public static void main(String[] args) {

        @Getter
        @Setter
        class Aluno{

            Integer id;
            String nome;

            Aluno(Integer id, String nome){
                this.id = id;
                this.nome = nome;
            }
        }

        Predicate<Aluno> verificaLetraM = str -> str.nome.toUpperCase().contains("M");


        var listaDeAlunos = List.of(
                new Aluno(1, "Mateus"),
                new Aluno(2, "Bruna"),
                new Aluno(3, "Ronaldo"));

        var ids = listaDeAlunos.stream().filter(verificaLetraM)
                                                    .map(Aluno::getId)
                                                    .collect(Collectors.toList());
        for(Integer alunoid : ids){
            System.out.println(alunoid);
        }




    }
}
