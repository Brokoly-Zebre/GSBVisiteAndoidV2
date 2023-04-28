package com.example.gsbvisite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gsbvisite.databinding.ActivityUserBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Visiteurs_Activity extends AppCompatActivity {

    private ActivityUserBinding binding;
    private Token token;
    private String username;
    private Visiteurs visiteurs;
    private Visiteur visiteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        Intent i = getIntent();
        token = (Token) i.getSerializableExtra("token");
        username = (String) i.getSerializableExtra("username");
        GsbApiServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbApiServices.class);

        Call<Visiteurs> call = service.getVisiteurs(token.getBearerToken());
        call.enqueue(new Callback<Visiteurs>() {
            @Override
            public void onResponse(Call<Visiteurs> call, Response<Visiteurs> response) {
                if (response.code() == 200) {
                    visiteurs = response.body();
                    for (Visiteur unVisiteur : visiteurs.getVisiteurs()) {
                        if (unVisiteur.getUsername().equals(username)) {
                            visiteur = unVisiteur;
                            binding.textViewWelcome.setText("Bonjour" + visiteur.getPrenom());
                            binding.textViewEmailVisiteur.setText(visiteur.getEmail());
                        }
                        ArrayList<Practicien> praticiens = new ArrayList<>();
                        praticiens.add(new Practicien("James ", "Lebron"));
                        praticiens.add(new Practicien("Davis", "Anthony"));
                        praticiens.add(new Practicien("Reaves", "Austin"));

                        binding.recyclerView.setHasFixedSize(true);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                        binding.recyclerView.setLayoutManager(layoutManager);
                        binding.recyclerView.setFocusable(false);
                    }
                }
            }

            @Override
            public void onFailure(Call<Visiteurs> call, Throwable t) {

            }


        });
    }
}