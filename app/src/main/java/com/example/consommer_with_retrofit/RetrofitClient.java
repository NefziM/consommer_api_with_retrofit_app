package com.example.consommer_with_retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    //L'URL de base est définie pour l'API. Retrofit est configuré pour utiliser un convertisseur Gson pour parser les réponses JSON.
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        //Si l'instance retrofit est null, une nouvelle instance est créée avec la configuration adéquate.
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
