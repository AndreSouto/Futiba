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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.util.List;

public class CriarPeladaActivity extends AppCompatActivity {

    private Button criar, zoeira, casual, competitivo, cameraButton;
    private EditText nome, preco, horario_inicio, horario_fim, participantes, endereco;
    private ImageView fotoTirada;
    private Geocoder gc;
    private String auxiliar;
    private double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_pelada);


        this.fotoTirada = (ImageView)this.findViewById(R.id.fotoTirada);

        gc = new Geocoder(this);

        nome = (EditText) findViewById(R.id.edittext);
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


                //"Convertendo" o endereco em latitude e longitude
                auxiliar = endereco.getText().toString();

                try {

                    List<Address> list = gc.getFromLocationName(auxiliar,1);
                    Address add = list.get(0);
                    String locality = add.getLocality();

                    latitude = add.getLatitude();
                    longitude = add.getLongitude();

                } catch (IOException e) {
                    e.printStackTrace();
                }


                //Cria a pelada e salva no banco de dados



                BuscarScreen(); //Volta para a tela BuscarActivity

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


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            fotoTirada.setImageBitmap(photo);
        }
    }


}
