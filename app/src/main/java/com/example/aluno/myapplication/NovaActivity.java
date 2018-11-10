package com.example.aluno.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aluno.myapplication.api.AlunoApi;
import com.example.aluno.myapplication.api.RetrofitFactory;
import com.example.aluno.myapplication.domain.ListaAlunos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NovaActivity extends Activity {

    private String nome;
    private String nota;
    private List<ListaAlunos> alunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_activity);

        Intent intent = getIntent();
        nome = intent.getStringExtra("nome");

        AlunoApi api = RetrofitFactory.getAlunoApi();
        api.getAlunos().enqueue(new Callback<List<ListaAlunos>>() {

            @Override
            public void onResponse(Call<List<ListaAlunos>> call, Response<List<ListaAlunos>> response) {
                alunos = response.body();
                Log.i("alunos:", alunos.toString());
                for (ListaAlunos aluno : alunos) {
                    if (aluno.getNome().contains(nome)) {
                        TextView nomeView = findViewById(R.id.aluno);
                        nomeView.setText(aluno.getNome());
                        TextView notaView = findViewById(R.id.nota);
                        notaView.setText(aluno.getNota());
                        if(Integer.parseInt(nota) > 6){
                            ImageView myImageView = (ImageView)findViewById(R.id.img);
                            myImageView.setImageResource(R.drawable.azul);
                        }else {
                            ImageView myImageView = (ImageView)findViewById(R.id.img);
                            myImageView.setImageResource(R.drawable.vermelho);
                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<List<ListaAlunos>> call, Throwable t) {
                Log.e("Erro", "Erro ao recuperar alunos", t);
            }
        });

    }
}
