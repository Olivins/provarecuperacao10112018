package com.example.aluno.myapplication.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static Retrofit getApiCaller() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        return new Retrofit.Builder()
                .baseUrl("https://provaddm2018.000webhostapp.com/lista_de_alunos")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public static AlunoApi getAlunoApi() {
        return getApiCaller().create(AlunoApi.class);
    }
}
