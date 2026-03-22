package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editNom, editEmail, editPhone, editAdresse;
    private Spinner spinnerVille;
    private Button btnEnvoyer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editNom=findViewById(R.id.nom);
        editEmail=findViewById(R.id.email);
        editAdresse=findViewById(R.id.adresse);
        editPhone=findViewById(R.id.phone);
        spinnerVille=findViewById(R.id.ville);
        btnEnvoyer=findViewById(R.id.btnEnvoyer);

        String[] villes= {"Marrakesh","Safi", "Tetouan", "Azillal", "Tanger", "Casablanca", "Rabat","El jadida","Sale","Youssoufia","Fes"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item , villes
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVille.setAdapter(adapter);
        btnEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = editNom.getText().toString().trim();
                String phone = editPhone.getText().toString().trim();
                String email = editEmail.getText().toString().trim();
                String adresse = editAdresse.getText().toString().trim();
                String ville = spinnerVille.getSelectedItem().toString();

                if (nom.isEmpty()) {
                    editNom.setError("Veuillez entrer votre nom et preenom !");
                    editNom.requestFocus();
                    return;
                }

                if (email.isEmpty()) {
                    editEmail.setError("Veuillez entrer votre mail !");
                    editEmail.requestFocus();
                    return;
                }

                if (phone.isEmpty()) {
                    editPhone.setError("Veuillez entrer votre numéro de telephone !");
                    editPhone.requestFocus();
                    return;
                }

                if (adresse.isEmpty()) {
                    editAdresse.setError("Veuillez entrer votre adresse !");
                    editAdresse.requestFocus();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, Screen2Activity.class);
                intent.putExtra("nom", nom);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);
                intent.putExtra("adresse",adresse);
                intent.putExtra("ville",ville);

                startActivity(intent);

            }
        });
    }
}