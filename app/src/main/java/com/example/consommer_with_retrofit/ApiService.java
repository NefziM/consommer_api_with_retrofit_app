package com.example.consommer_with_retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ApiService {
    //Cette interface définit les requêtes HTTP utilisées pour obtenir les données.
    //Méthode getUsers :Cette méthode utilise l'annotation @GET pour effectuer une requête HTTP GET à l'endpoint /users et récupérer une liste d'utilisateurs.

    @GET("users")
    Call<List<User>> getUsers();
}
