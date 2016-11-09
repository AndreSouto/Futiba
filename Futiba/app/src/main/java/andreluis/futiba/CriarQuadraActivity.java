package andreluis.futiba;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CriarQuadraActivity extends AppCompatActivity {

    private Button ruim, regular, bom, society, futsal, grama, criar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_quadra);



        criar = (Button) findViewById(R.id.criar);
        criar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Acao ao clicar em CRIAR! Banco de Dados
                BuscarScreen();


            }
        });

    /*********************Opcoes de conservacao da quadra********************************************/

        ruim = (Button) findViewById(R.id.ruim);
        ruim.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                ruim.setElevation(1000);
                regular.setElevation(0);
                bom.setElevation(0);

            }
        });


        regular = (Button) findViewById(R.id.regular);
        regular.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                ruim.setElevation(0);
                regular.setElevation(1000);
                bom.setElevation(0);

            }
        });


        bom = (Button) findViewById(R.id.bom);
        bom.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                ruim.setElevation(0);
                regular.setElevation(0);
                bom.setElevation(1000);

            }
        });



     /***********************************************************************************************/


     /*********************Opcoes de tipo da quadra**************************************************/

        society = (Button) findViewById(R.id.society);
        society.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                society.setElevation(1000);
                futsal.setElevation(0);
                grama.setElevation(0);

            }
        });


        futsal = (Button) findViewById(R.id.futsal);
        futsal.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                society.setElevation(0);
                futsal.setElevation(1000);
                grama.setElevation(0);

            }
        });


        grama = (Button) findViewById(R.id.grama);
        grama.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                society.setElevation(0);
                futsal.setElevation(0);
                grama.setElevation(1000);

            }
        });



     /***********************************************************************************************/

    }


    public void BuscarScreen() {              //Chama a BuscaActivity

        Intent buscarScreen = new Intent(this, BuscarActivity.class);
        startActivity(buscarScreen);
    }

}
