package com.example.gsbvisite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gsbvisite.databinding.ActivityMainBinding;
import com.example.gsbvisite.databinding.ActivityUserBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private Token token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.BtnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.Login.getText().toString();
                String password = binding.Password.getText().toString();

                if(username.equals("") == false || password.equals("") == false) {
                    GsbApiServices service =
                            RetrofitClientInstance.getRetrofitInstance().create(GsbApiServices.class);
                    Call<Token> call = service.getToken(new Visiteur(username, password));
                    call.enqueue(new Callback<Token>() {
                        @Override
                        public void onResponse(Call<Token> call, Response<Token> response) {
                            if (response.code() == 200) {
                                token = response.body();
                                Intent intentVisiteur_Activity = new Intent(getApplicationContext(), Visiteurs_Activity.class);
                                intentVisiteur_Activity.putExtra("token", token);
                                intentVisiteur_Activity.putExtra("username", username);
                                startActivity(intentVisiteur_Activity);
                            }

                        }

                        @Override
                        public void onFailure(Call<Token> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Une Erreur est survenue !",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre usermane et password",
                            Toast.LENGTH_SHORT).show();
                    }
            }


        });

    }
}