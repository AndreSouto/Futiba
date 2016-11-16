package andreluis.futiba;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.parse.ParseObject;

public class CriarQuadraActivity extends AppCompatActivity {

    private Button ruim, regular, bom, society, futsal, grama, criar;
    private ImageButton luz, agua, pago, banheiro;
    private int intLuz = 0, intAgua = 0, intPago = 0, intBanheiro = 0;
    private int id = 0, nota, latitude = 0, longitude = 0;
    private boolean agua_perto, banheiro_perto, luz_perto, quadra_paga;
    private String tipo;
    private ParseObject parse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_quadra);


    /**************Agua, luz, banheiro e pago******************************************************/

        agua = (ImageButton) findViewById(R.id.agua);
        agua.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(intAgua == 0) {
                    agua.setImageResource(R.drawable.c);
                    intAgua = 1;
                    agua_perto = true;
                }
                else{
                    agua.setImageResource(R.drawable.e);
                    intAgua = 0;
                    agua_perto = false;
                }

            }
        });


        luz = (ImageButton) findViewById(R.id.luz);
        luz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(intLuz == 0) {
                    luz.setImageResource(R.drawable.h);
                    intLuz = 1;
                    luz_perto = true;
                }
                else{
                    luz.setImageResource(R.drawable.b);
                    intLuz = 0;
                    luz_perto = false;
                }



            }
        });


        banheiro = (ImageButton) findViewById(R.id.banheiro);
        banheiro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(intBanheiro == 0) {
                    banheiro.setImageResource(R.drawable.f);
                    intBanheiro = 1;
                    banheiro_perto = true;
                }
                else{
                    banheiro.setImageResource(R.drawable.a);
                    intBanheiro = 0;
                    banheiro_perto = false;
                }



            }
        });


        pago = (ImageButton) findViewById(R.id.pago);
        pago.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(intPago == 0) {
                    pago.setImageResource(R.drawable.d);
                    intPago = 1;
                    quadra_paga = true;
                }
                else{
                    pago.setImageResource(R.drawable.g);
                    intPago = 0;
                    quadra_paga = false;
                }



            }
        });

     /*********************************************************************************************/



        criar = (Button) findViewById(R.id.criar);
        criar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Cria a quadra e salva no banco de dados
                parse = new ParseObject("ArenaTable");


                parse.put("nota", nota);
                parse.put("latitude", -15.758625);
                parse.put("longitude", -47.887256);
                parse.put("agua_perto", agua_perto);
                parse.put("banheiro_perto", banheiro_perto);
                parse.put("tipo",tipo);
                parse.put("quadra_paga", quadra_paga);
                parse.put("luz_perto", luz_perto);
                parse.saveInBackground();


                BuscarScreen(); //Volta para a tela BuscarActivity


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
                nota = 0;

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
                nota = 1;

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
                nota = 2;

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
                tipo = "society";

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
                tipo = "futsal";

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
                tipo = "grama";

            }
        });



     /***********************************************************************************************/

    }


    public void BuscarScreen() {              //Chama a BuscaActivity

        Intent buscarScreen = new Intent(this, BuscarActivity.class);
        startActivity(buscarScreen);
    }

}
