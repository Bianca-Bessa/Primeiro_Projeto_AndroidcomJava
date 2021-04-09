package br.com.biancabessa.primeiroprojetojava;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Runnable{

    protected static final int TIMER_RUNTIME = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Muda a tela apos alguns segundos
        /*Handler handler = new Handler();
        handler.postDelayed(this, 2000);*/

        //mensagem para o console(terminal)
        Log.i("MeuApp", "Bem-Vindo ao Android Studio");

        //Declaração de variavel para alterar texto
        Button botao = findViewById(R.id.meuBotao);
        TextView texto = findViewById(R.id.meuTexto);
        texto.setText("Ola mundo");

        //Evento de clicar botão, esse muda o texto selecionado
        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                texto.setText(("Clicou"));
            }
        });
    }

    //Essa é função tras a outra tela apos os segundos acabarem.
    @Override
    public void run(){
        startActivity(new Intent(this, TelaPrincipal.class));
        finish();
    }

    public void alertaNormal(View view){
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Funcionou");
        alertDialog.setMessage("Botão Alerta 1");
        alertDialog.show();
    }

    public void alertaX(View view){
        //Acessar botão
        Button b = (Button)view;

        //Preparar mensagem
        String mensagem = "Você apertou o botão";

        //Adiciona o nome do botão na mensagem
        mensagem = mensagem.concat(b.getText().toString());

        //mostrar caixa de mensagem
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setMessage(mensagem);
        alertDialog.show();
    }

    public void clicaToastLongo(View view){
        Toast toast = Toast.makeText(MainActivity.this, "Longo Toast", Toast.LENGTH_LONG);
        toast.show();
    }

    public void clicaToastCurto(View view) {
        Toast toast = Toast.makeText(MainActivity.this, "Curto Toast", Toast.LENGTH_SHORT);
        toast.show();
    }
}