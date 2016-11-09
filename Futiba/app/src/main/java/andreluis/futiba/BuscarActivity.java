package andreluis.futiba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class BuscarActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button homeButton, peladaButton, quadraButton, addPeladaButton;
    private ImageButton i_pesquisa, i_filtro, i_lista;
    private ImageView i_pelada_quadra;
    private int amarelo = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        i_pesquisa = (ImageButton)findViewById(R.id.imageButton3);
        i_filtro = (ImageButton)findViewById(R.id.imageButton);
        i_lista = (ImageButton)findViewById(R.id.imageButton2);
        i_pelada_quadra = (ImageView)findViewById(R.id.imageView);


        peladaButton = (Button)findViewById(R.id.buttonPeladas);
        peladaButton.setOnClickListener(new View.OnClickListener() {        //Icones de activity_buscar se tornam amarelos

            @Override
            public void onClick(View view) {

                i_pesquisa.setImageResource(R.drawable.pesquisapeladas);
                i_filtro.setImageResource(R.drawable.filtropeladas);
                i_lista.setImageResource(R.drawable.listapeladas);
                i_pelada_quadra.setImageResource(R.drawable.addpelada_1);
                amarelo = 1;

            }
        });

        quadraButton = (Button)findViewById(R.id.buttonQuadras);
        quadraButton.setOnClickListener(new View.OnClickListener() {        //Icones de activity_buscar se tornam vermelhos

            @Override
            public void onClick(View view) {

                i_pesquisa.setImageResource(R.drawable.pesquisav);
                i_filtro.setImageResource(R.drawable.filtrov);
                i_lista.setImageResource(R.drawable.listav);
                i_pelada_quadra.setImageResource(R.drawable.addquadra1);
                amarelo = 0;

            }
        });

        addPeladaButton = (Button)findViewById(R.id.buttonAddPelada);
        addPeladaButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(amarelo == 0){
                    CriarQuadraScreen();

                }
                else if(amarelo == 1){
                    CriarPeladaScreen();

                }

            }
        });



        homeButton = (Button)findViewById(R.id.button2);
        homeButton.setOnClickListener(new View.OnClickListener() {          //Ao clicar no botao homeButton(p/ voltar para
                                                                            //o menu do app)
            @Override
            public void onClick(View view) {

                MenuScreen();

            }
        });
    }

    public void MenuScreen(){

        Intent Main = new Intent(this,MenuActivity.class);      //mudar para activity Menu
        startActivity(Main);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

       // BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.footballfield);

        // Add a marker in Sydney and move the camera
        //LatLng q1 = new LatLng(-15.75562, -47.8910);
        //mMap.addMarker(new MarkerOptions().position(q1)
           //     .icon(icon)
          //    .title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(q1));
    }

    
    public void CriarQuadraScreen(){

        Intent cqs = new Intent(this, CriarQuadraActivity.class);
        startActivity(cqs);
    }

    public void CriarPeladaScreen(){

        Intent cps = new Intent(this, CriarPeladaActivity.class);
        startActivity(cps);
    }

}
