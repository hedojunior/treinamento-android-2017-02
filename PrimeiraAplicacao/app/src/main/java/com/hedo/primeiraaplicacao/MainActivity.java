package com.hedo.primeiraaplicacao;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

//    Tag para que seja mais fácil fazer a filtragem nos logs do Logcat.
    String tag = "TesteLifecycle";

//    Componentes utilizados pela Activity.
    TextView meuTextView;

    Button buttonSegundaActivity;

    EditText editTextTelefone;

//  Método de criação da activity. Primeiro método do Lifecycle, onde a tela ainda não é visível pelo usuário. Este método só executa uma vez durante toda a vida útil
//  da Activity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(tag, "MainActivity.onCreate");
        setContentView(R.layout.activity_main);
        initComponents();
        buttonSegundaActivity.setOnClickListener(this);
    }

//  Faz todos os findViewById dos componentes da tela.
    private void initComponents() {
        meuTextView = findViewById(R.id.name_tv);
        buttonSegundaActivity = findViewById(R.id.second_activity_bt);
        editTextTelefone = findViewById(R.id.telephone_et);
    }

//  Segundo método do lifecycle, é responsável por tornar a activity visível, porém não utilizável. Executa sempre após o onCreate e onRestart.
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(tag, "MainActivity.onStart");
    }

//  Terceiro método do lifecycle, torna a tela utilizável e leva a activity ao seu estado final, em primeiro plano. é chamado sempre após o onStart e após o onPause
//  somente quando a activity é resumida, e não finalizada.
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag, "MainActivity.onResume");
    }

    // Quarto método do lifecycle, é chamado quando a activity sai de primeiro plano porém continua visível.
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(tag, "MainActivity.onPause");
    }

//  Quinto método do lifecycle, é chamado quando a activity sai totalmente de primeiro plano, não sendo mais visível. Após ele, caso o usuário volte a navegar para a
//  activity, é chamado o método onRestart. Caso contrário, é chamado o método onDestroy em seguida.
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag, "MainActivity.onStop");
    }

//  Este método é um "anexo" ao lifecycle. É chamado somente após o onStop, caso o usuário navegue novamente para a activity.
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(tag, "MainActivity.onRestart");
    }

//  Último método do lifecycle, é chamado quando for necessário o descarte da activity, seja por motivos de memória ou por não necessitar mais da Activity.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag, "MainActivity.onDestroy");
    }

//  Implementação do método onClick, necessário pois a classe implementa View.OnClickListener
    @Override
    public void onClick(View v) {
        String telefone = editTextTelefone.getText().toString();

        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + telefone));

        startActivity(intent);

    }
}
