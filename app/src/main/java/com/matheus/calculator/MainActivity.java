package com.matheus.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button numZero, numUm, numDois, numTres, numQuatro, numCinco, numSeis, numSete,
    numOito, numNove, ponto, limpar, divisao, multiplicacao, subtracao, soma, igual;

    private TextView txtExpressao, txtResultado;

    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();

        getSupportActionBar().hide();

        numZero.setOnClickListener(this);
        numUm.setOnClickListener(this);
        numDois.setOnClickListener(this);
        numTres.setOnClickListener(this);
        numQuatro.setOnClickListener(this);
        numCinco.setOnClickListener(this);
        numSeis.setOnClickListener(this);
        numSete.setOnClickListener(this);
        numOito.setOnClickListener(this);
        numNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();
                if(!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length() - 1;
                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Expression expression = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expression.evaluate();
                    long longResult = (long) resultado;

                    if(resultado ==  (double) longResult){
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    }else{
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                } catch (Exception e){

                }
            }
        });
    }
    private void IniciarComponentes(){
        numZero = findViewById(R.id.bt_numero_zero);
        numUm = findViewById(R.id.bt_numero_um);
        numDois = findViewById(R.id.bt_numero_dois);
        numTres = findViewById(R.id.bt_numero_tres);
        numQuatro = findViewById(R.id.bt_numero_quatro);
        numCinco = findViewById(R.id.bt_numero_cinco);
        numSeis = findViewById(R.id.bt_numero_seis);
        numSete = findViewById(R.id.bt_numero_sete);
        numOito = findViewById(R.id.bt_numero_oito);
        numNove = findViewById(R.id.bt_numero_nove);
        ponto = findViewById(R.id.bt_ponto);
        limpar = findViewById(R.id.bt_limpar);
        divisao = findViewById(R.id.bt_divisao);
        multiplicacao = findViewById(R.id.bt_multiplicacao);
        subtracao = findViewById(R.id.bt_subtracao);
        soma = findViewById(R.id.bt_adicao);
        igual = findViewById(R.id.bt_igual);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.bt_apagar);
    }

    public void AcrescentarUmaExpressao(String string, boolean limpar_dados){

        if (txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }
        if (limpar_dados){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }else{
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_numero_zero:
                AcrescentarUmaExpressao(" 0", true);
                break;

            case R.id.bt_numero_um:
                AcrescentarUmaExpressao(" 1", true);
                break;

            case R.id.bt_numero_dois:
                AcrescentarUmaExpressao(" 2", true);
                break;

            case R.id.bt_numero_tres:
                AcrescentarUmaExpressao(" 3", true);
                break;

            case R.id.bt_numero_quatro:
                AcrescentarUmaExpressao(" 4", true);
                break;

            case R.id.bt_numero_cinco:
                AcrescentarUmaExpressao(" 5", true);
                break;

            case R.id.bt_numero_seis:
                AcrescentarUmaExpressao(" 6", true);
                break;

            case R.id.bt_numero_sete:
                AcrescentarUmaExpressao(" 7", true);
                break;

            case R.id.bt_numero_oito:
                AcrescentarUmaExpressao(" 8", true);
                break;

            case R.id.bt_numero_nove:
                AcrescentarUmaExpressao(" 9", true);
                break;

            case R.id.bt_ponto:
                AcrescentarUmaExpressao(".", true);
                break;

            case R.id.bt_multiplicacao:
                AcrescentarUmaExpressao("*", false);
                break;

            case R.id.bt_divisao:
                AcrescentarUmaExpressao("/", false);
                break;

            case R.id.bt_subtracao:
                AcrescentarUmaExpressao("-", false);
                break;

            case R.id.bt_adicao:
                AcrescentarUmaExpressao("+", false);
                break;
        }
    }
}