package com.pl.edu.prz.aplikacjadietetyczna; //pakowanie

import android.content.Intent;// importowanie rozmiar treści
import android.os.Bundle;// importowanie systemu operacyjnego android do obiektu Bundle
import android.view.View;// importowanie okna widokowego androida
import android.widget.Button;// importowanie z panelu bocznego przycisk do aplikcji android
import android.support.v7.app.AppCompatActivity;//importujemy wsparcie v7


public class MainActivity1 extends AppCompatActivity {// publiczna klasa MainActivity1 rozszerzenie działania aplikacji CompatActivity
    private Button button; //prywatny przycisk przycisku
    @Override
    //kreujemy w modyfikatorze protected funkcji void pakiet zapisanych InstanceState
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        button = (Button) findViewById(R.id.button);//przypisujemy pola View z pliku xml do zmiennych
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //przekazywanie danych pomiędzy Activity
                Intent intent = new Intent(MainActivity1.this , MainActivity2.class);
                startActivity(intent);//start aktywności
            }
        });
    }

    }

