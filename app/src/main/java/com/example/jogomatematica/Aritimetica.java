package com.example.jogomatematica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Aritimetica extends AppCompatActivity {

    TextView num1, num2, operador, gabarito, score;
    EditText resposta;
    Button botaoVerificar, botaoNext;
    int contador=0, gabaritoInt, pontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritimetica);

        this.num1 = findViewById(R.id.textNum1);
        this.num2 = findViewById(R.id.textNum2);
        this.operador = findViewById(R.id.textOperador);
        this.gabarito = findViewById(R.id.textGabarito);
        this.score = findViewById(R.id.textScore);

        this.resposta = findViewById(R.id.editResposta);

        this.botaoVerificar = findViewById(R.id.btnAritimetica);
        this.botaoNext = findViewById(R.id.btnAriNext);

        this.generateValues();
    }

    public void Verify(View view) {
        this.gabarito.setVisibility(View.VISIBLE);
        if (Integer.parseInt(this.resposta.getText().toString()) == this.gabaritoInt) {
            this.gabarito.setText("Resposta correta");
            this.pontos += 20;
        } else {
            this.gabarito.setText("Resposta incorreta - Valor correto é: "+ this.gabaritoInt);
        }
        this.botaoVerificar.setVisibility(View.GONE);
        this.botaoNext.setVisibility(View.VISIBLE);
        if (this.contador >= 5) {
            this.botaoNext.setText("Finalizar");
        }
    }

    public void Next(View view) {
        this.botaoNext.setVisibility(View.GONE);
        this.gabarito.setVisibility(View.GONE);
        if (this.contador < 5) {
            this.generateValues();
            this.botaoVerificar.setVisibility(View.VISIBLE);
        } else {
            this.score.setVisibility(View.VISIBLE);
            this.score.setText("Pontuação: "+this.pontos+"/100");
        }
    }

    private void generateValues() {
        Random r = new Random();
        int numRandom1 = r.nextInt(10);
        int numRandom2 = r.nextInt(10);

        this.num1.setText(String.valueOf(numRandom1));
        this.num2.setText(String.valueOf(numRandom2));
        if (r.nextInt(2) == 0) {
            this.operador.setText("+");
            this.gabaritoInt = numRandom1 + numRandom2;
        } else {
            this.operador.setText("-");
            this.gabaritoInt = numRandom1 - numRandom2;
        }
        this.contador++;
    }
}