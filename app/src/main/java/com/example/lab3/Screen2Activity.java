package com.example.lab3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Screen2Activity extends AppCompatActivity {

    private TextView recap;
    private Button btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        recap = findViewById(R.id.recap);
        btnRetour = findViewById(R.id.btnRetour);

        String nom = getIntent().getStringExtra("nom");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");
        String adresse = getIntent().getStringExtra("adresse");
        String ville = getIntent().getStringExtra("ville");

        String messagefinal = "Votre Nom Complet : " + nom + "\n\n" +
                "Votre Numero de Telephone : " + phone + "\n\n" +
                "Votre Adresse : " + adresse + "\n\n" +
                "Votre Email : " + email + "\n\n" +
                "Ville : " + ville;

        recap.setText(messagefinal);

        btnRetour.setOnClickListener(v -> finish());
    }
}