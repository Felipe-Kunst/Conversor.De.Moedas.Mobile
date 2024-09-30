package com.example.conversordemoedas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText valorEmReal;
    private Button botaoConverter;
    private TextView resultado;

    private static final double COTACAO_DOLAR = 5.46;
    private static final double COTACAO_EURO = 6.10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorEmReal = findViewById(R.id.valorEmReal);
        botaoConverter = findViewById(R.id.botaoConverter);
        resultado = findViewById(R.id.resultado);

        botaoConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                converter();
            }
        });
    }

    private void converter() {
        String valorString = valorEmReal.getText().toString();
        if (!valorString.isEmpty()) {
            double valorBRL = Double.parseDouble(valorString);
            double valorUSD = valorBRL / COTACAO_DOLAR;
            double valorEUR = valorBRL / COTACAO_EURO;

            // Exibir resultado
            resultado.setText(String.format("USD: %.2f\nEUR: %.2f", valorUSD, valorEUR));
            resultado.setVisibility(View.VISIBLE);
        } else {
            resultado.setText("Por favor, insira um valor.");
            resultado.setVisibility(View.VISIBLE);
        }
    }
}
