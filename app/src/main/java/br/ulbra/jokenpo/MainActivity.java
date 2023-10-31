package br.ulbra.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtResultado = findViewById(R.id.txtResultado);
    ImageView imagemResultado = findViewById(R.id.padrao);
    int pontuacaoJogador = 0,pontuacaoApp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void selecionadoPedra(View view){
        this.opcaoSelecionado("Pedra");
    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionado("Papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionado("Tesoura");
    }
    public void opcaoSelecionado(String opcaoSelecionada){
        String opcoes[] = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[new Random().nextInt(3)];
        switch (opcaoApp){
            case "Pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if(opcaoApp.equals("Tesoura") && opcaoSelecionada.equals("Papel")
                || opcaoApp.equals("Papel") && opcaoSelecionada.equals("Pedra")
                || opcaoApp.equals("Pedra") && opcaoSelecionada.equals("Tesoura")){
            txtResultado.setText("Você perdeu!");
            pontuacaoApp++;
            atualizarPlacar();

        }else if(opcaoSelecionada.equals("Tesoura") && opcaoApp.equals("Papel")
                || opcaoSelecionada.equals("Papel") && opcaoApp.equals("Pedra")
                || opcaoSelecionada.equals("Pedra") && opcaoApp.equals("Tesoura")){
            txtResultado.setText("Você venceu!");
            pontuacaoJogador++;
            atualizarPlacar();

        }else{
            txtResultado.setText("EMPATE!");
        }
    }
    public void atualizarPlacar(){
        TextView txtPlacar = findViewById(R.id.txtPlacar);
        txtPlacar.setText("Jogador: " + pontuacaoJogador + " - App: " + pontuacaoApp);
        }
    public void reiniciarJogo(View view){
        pontuacaoJogador = 0;
        pontuacaoApp = 0;
        atualizarPlacar();
        ImageView imageResultado = findViewById(R.id.padrao);
        imageResultado.setImageResource(android.R.color.transparent);
    }

}