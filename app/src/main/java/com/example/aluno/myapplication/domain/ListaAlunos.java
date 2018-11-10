package com.example.aluno.myapplication.domain;

public class ListaAlunos {


    private String nome;
    private String nota;

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ListaAlunos{" +
                "nome='" + nome + '\'' +
                ", nota=" + nota +
                '}';
    }
}
