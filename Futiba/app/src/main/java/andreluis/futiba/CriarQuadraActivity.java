package andreluis.futiba;

import android.annotation.TargetApi;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.parse.ParseObject;

import java.io.IOException;
import java.util.List;

public class CriarQuadraActivity extends AppCompatActivity {

    private EditText enderecoEditText, nomeEditText;
    private ImageButton ruim, regular, bom, society, futsal, grama;
    private Button criar;
    private ImageButton luz, agua, pago, banheiro;
    private int intLuz = 0, intAgua = 0, intPago = 0, intBanheiro = 0;
    private int id = 0, nota;
    private boolean agua_perto, banheiro_perto, luz_perto, quadra_paga;
    private String tipo, auxiliar_endereco, auxiliar_nome;
    private ParseObject parse;
    private double latitude = 0, longitude = 0;
    private Geocoder gc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_quadra);


        //muda a cor do STATUS BAR
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.red));
        }


        enderecoEditText = (EditText) findViewById(R.id.endereco);
        nomeEditText = (EditText) findViewById(R.id.nomedaquadra);
        gc = new Geocoder(this);


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

                //"Convertendo" o endereco em latitude e longitude
                auxiliar_endereco = enderecoEditText.getText().toString();
                auxiliar_nome = nomeEditText.getText().toString();

                try {

                    List<Address> list = gc.getFromLocationName(auxiliar_endereco,1);
                    Address add = list.get(0);
                    String locality = add.getLocality();

                    latitude = add.getLatitude();
                    longitude = add.getLongitude();

                } catch (IOException e) {
                    e.printStackTrace();
                }


                //Cria a quadra e salva no banco de dados
                parse = new ParseObject("ArenaTable");


                parse.put("nome", auxiliar_nome);
                parse.put("nota", nota);
                parse.put("latitude", latitude);
                parse.put("longitude", longitude);
                parse.put("agua_perto", agua_perto);
                parse.put("banheiro_perto", banheiro_perto);
                parse.put("tipo", tipo);
                parse.put("quadra_paga", quadra_paga);
                parse.put("luz_perto", luz_perto);
                parse.saveInBackground();


                BuscarScreen(); //Volta para a tela BuscarActivity


            }
        });


    /*********************Opcoes de conservacao da quadra********************************************/

        ruim = (ImageButton) findViewById(R.id.ruim);
        ruim.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                ruim.setImageResource(R.drawable.ruimv);
                regular.setImageResource(R.drawable.regular);
                bom.setImageResource(R.drawable.bom);
                nota = 0;

            }
        });


        regular = (ImageButton) findViewById(R.id.regular);
        regular.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                ruim.setImageResource(R.drawable.ruim);
                regular.setImageResource(R.drawable.regularv);
                bom.setImageResource(R.drawable.bom);
                nota = 1;

            }
        });


        bom = (ImageButton) findViewById(R.id.bom);
        bom.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                ruim.setImageResource(R.drawable.ruim);
                regular.setImageResource(R.drawable.regular);
                bom.setImageResource(R.drawable.bomv);
                nota = 2;

            }
        });



     /***********************************************************************************************/


     /*********************Opcoes de tipo da quadra**************************************************/

        society = (ImageButton) findViewById(R.id.society);
        society.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                society.setImageResource(R.drawable.societyv);
                futsal.setImageResource(R.drawable.futsal);
                grama.setImageResource(R.drawable.grama);
                tipo = "society";

            }
        });


        futsal = (ImageButton) findViewById(R.id.futsal);
        futsal.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                society.setImageResource(R.drawable.society);
                futsal.setImageResource(R.drawable.futsalv);
                grama.setImageResource(R.drawable.grama);
                tipo = "futsal";

            }
        });


        grama = (ImageButton) findViewById(R.id.grama);
        grama.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                society.setImageResource(R.drawable.society);
                futsal.setImageResource(R.drawable.futsal);
                grama.setImageResource(R.drawable.gramav);
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
