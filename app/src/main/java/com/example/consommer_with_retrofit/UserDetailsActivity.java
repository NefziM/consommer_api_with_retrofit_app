package com.example.consommer_with_retrofit;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UserDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        // Récupération des données passées
        String name = getIntent().getStringExtra("name");
        String username = getIntent().getStringExtra("username");
        String email = getIntent().getStringExtra("email");
        String address = getIntent().getStringExtra("address");

        // Associer les TextViews et afficher les données
        ((TextView) findViewById(R.id.nameTextView)).setText("Name: " + name);
        ((TextView) findViewById(R.id.usernameTextView)).setText("Username: " + username);
        ((TextView) findViewById(R.id.emailTextView)).setText("Email: " + email);
        ((TextView) findViewById(R.id.addressTextView)).setText("Address: " + address);
    }
}
