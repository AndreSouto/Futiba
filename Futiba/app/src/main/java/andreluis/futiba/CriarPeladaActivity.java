package andreluis.futiba;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.parse.ParseObject;

import java.io.IOException;
import java.util.List;

public class CriarPeladaActivity extends AppCompatActivity {

    private ImageButton zoeira, casual, competitivo;
    private Button cameraButton, criar;
    private EditText nome, preco, horario_inicio, horario_fim, participantes, endereco;
    private ImageView fotoTirada;
    private Geocoder gc;
    private String auxiliar_endereco, auxiliar_nome, tipo_da_pelada, auxiliar_preco,
                    auxiliar_horario_inicio, auxiliar_horario_fim, auxiliar_participantes;

    private double latitude, longitude;
    private ParseObject parse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_pelada);


        //muda a cor do STATUS BAR
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.yellow));
        }



        this.fotoTirada = (ImageView)this.findViewById(R.id.fotoTirada);

        gc = new Geocoder(this);

        nome = (EditText) findViewById(R.id.nome);
        endereco = (EditText) findViewById(R.id.endereco);
        preco = (EditText) findViewById(R.id.editText);
        horario_inicio = (EditText) findViewById(R.id.editText3);
        horario_fim = (EditText) findViewById(R.id.editText2);
        participantes = (EditText) findViewById(R.id.editText4);


        cameraButton = (Button) findViewById(R.id.cameraButton);            //Acesso a camera fotografica
        cameraButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI.getPath());
                startActivityForResult(intent, 1);
            }
        });


        criar = (Button) findViewById(R.id.criar);
        criar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                auxiliar_endereco = endereco.getText().toString();
                auxiliar_nome = nome.getText().toString();
                auxiliar_preco = preco.getText().toString();
                auxiliar_horario_inicio = horario_inicio.getText().toString();
                auxiliar_horario_fim = horario_fim.getText().toString();
                auxiliar_participantes = participantes.getText().toString();


                //"Convertendo" o endereco em latitude e longitude
                try {

                    List<Address> list = gc.getFromLocationName(auxiliar_endereco,1);
                    Address add = list.get(0);
                    String locality = add.getLocality();

                    latitude = add.getLatitude();
                    longitude = add.getLongitude();

                } catch (IOException e) {
                    e.printStackTrace();
                }


                //Cria a pelada e salva no banco de dados
                parse = new ParseObject("Pelada");


                parse.put("nome", auxiliar_nome);
                //parse.put("imagem",...); -- Foto da quadra
                parse.put("tipo", tipo_da_pelada);
                parse.put("latitude", latitude);
                parse.put("longitude", longitude);
                parse.put("preco", auxiliar_preco);
                parse.put("hoario_inicio", auxiliar_horario_inicio);
                parse.put("horario_fim", auxiliar_horario_fim);
                parse.put("participantes", auxiliar_participantes);
                parse.saveInBackground();



                BuscarScreen(); //Volta para a tela BuscarActivity

            }
        });


        zoeira = (ImageButton) findViewById(R.id.zoeira);
        zoeira.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                //zoeira.setImageResource(R.drawable.zoeiraa);  --TODO !!!
                casual.setImageResource(R.drawable.casual);
                competitivo.setImageResource(R.drawable.competitivo);
                tipo_da_pelada = "zoeira";

            }
        });


        casual = (ImageButton) findViewById(R.id.casual);
        casual.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                zoeira.setImageResource(R.drawable.zoeira);
                casual.setImageResource(R.drawable.casuala);
                competitivo.setImageResource(R.drawable.competitivo);
                tipo_da_pelada = "casual";

            }
        });


        competitivo = (ImageButton) findViewById(R.id.competitivo);
        competitivo.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                zoeira.setImageResource(R.drawable.zoeira);
                casual.setImageResource(R.drawable.casual);
                competitivo.setImageResource(R.drawable.competitivoa);
                tipo_da_pelada = "competitivo";

            }
        });


    }

    public void BuscarScreen() {              //Chama a BuscaActivity

        Intent buscarScreen = new Intent(this, BuscarActivity.class);
        startActivity(buscarScreen);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            fotoTirada.setImageBitmap(photo);
        }
    }


}
