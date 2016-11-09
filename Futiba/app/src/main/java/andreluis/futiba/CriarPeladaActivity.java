package andreluis.futiba;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CriarPeladaActivity extends AppCompatActivity {

    private Button criar, zoeira, casual, competitivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_pelada);



        criar = (Button) findViewById(R.id.criar);
        criar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                //Acao ao clicar em CRIAR! Banco de Dados
                BuscarScreen();

            }
        });


        zoeira = (Button) findViewById(R.id.zoeira);
        zoeira.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                zoeira.setElevation(1000);
                casual.setElevation(0);
                competitivo.setElevation(0);

            }
        });


        casual = (Button) findViewById(R.id.casual);
        casual.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                zoeira.setElevation(0);
                casual.setElevation(1000);
                competitivo.setElevation(0);

            }
        });


        competitivo = (Button) findViewById(R.id.competitivo);
        competitivo.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                zoeira.setElevation(0);
                casual.setElevation(0);
                competitivo.setElevation(1000);

            }
        });


    }

    public void BuscarScreen() {              //Chama a BuscaActivity

        Intent buscarScreen = new Intent(this, BuscarActivity.class);
        startActivity(buscarScreen);
    }


}
