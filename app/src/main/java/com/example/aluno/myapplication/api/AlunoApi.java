package com.example.aluno.myapplication.api;

import com.example.aluno.myapplication.domain.ListaAlunos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlunoApi {
    @GET("/precos")
    Call<List<ListaAlunos>> getAlunos();
}
