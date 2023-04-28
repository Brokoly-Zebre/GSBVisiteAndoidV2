package com.example.gsbvisite;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GsbApiServices {

        @GET("visiteurs")
        Call<Visiteurs> getVisiteurs(@Header("Authorization")String authorization);

        @GET("practiciens/{id}")
        Call<Practicien>getPracticien(@Header("Authorization") String authorization, @Path("id") String id );

        @POST("login_check")
        Call<Token> getToken(@Body Visiteur visiteur);


}
