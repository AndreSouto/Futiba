package andreluis.futiba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BuscarActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button homeButton, peladaButton, quadraButton, addPeladaButton;
    private ImageButton i_pesquisa, i_filtro, i_lista;
    private ImageView i_pelada_quadra, mapa_de_peladas, banheiro_icon, luz_icon, gratis_icon, bom_icon, agua_icon;
    private int amarelo = 1;
    private List<ArenaTable> atlist;
    private ArenaTable at;
    private ParseObject parse, parse_aux;
    private FrameLayout framelayout, framelayout2;
    private TextView namefromparse, typefromparse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);




        //muda a cor do STATUS BAR
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.green));
        }




        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        mapa_de_peladas = (ImageView) findViewById(R.id.mp);
        banheiro_icon = (ImageView) findViewById(R.id.banheiro1);
        gratis_icon = (ImageView) findViewById(R.id.gratis1);
        luz_icon = (ImageView) findViewById(R.id.luz1);
        bom_icon = (ImageView) findViewById(R.id.bom1);
        agua_icon = (ImageView) findViewById(R.id.agua1);
        namefromparse = (TextView) findViewById(R.id.nome1);
        typefromparse = (TextView) findViewById(R.id.tipo1);



        final BitmapDescriptor icon = BitmapDescriptorFactory.
                fromResource(R.drawable.footballfield); //Imagem que marca as quadras

        final BitmapDescriptor icon_peladas = BitmapDescriptorFactory.
                fromResource(R.drawable.uma); //Imagem que marca as peladas

        final BitmapDescriptor icon_peladas_duas = BitmapDescriptorFactory.
                fromResource(R.drawable.pel); //Imagem que marca as peladas

        final BitmapDescriptor icon_peladas_tres = BitmapDescriptorFactory.
                fromResource(R.drawable.tres); //Imagem que marca as peladas




        framelayout = (FrameLayout) findViewById(R.id.lay);      //Frame layout que aparece quando uma quadra eh selecionada
        framelayout.setOnTouchListener(new View.OnTouchListener() {     //Sair do frame layout quando for clicado
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                framelayout.setVisibility(View.GONE);
                return false;
            }
        });



        framelayout2 = (FrameLayout) findViewById(R.id.lay2);      //Frame layout que aparece quando uma pelada eh selecionada
        framelayout2.setOnTouchListener(new View.OnTouchListener() {     //Sair do frame layout quando for clicado
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                framelayout2.setVisibility(View.GONE);
                return false;
            }
        });



        i_pesquisa = (ImageButton) findViewById(R.id.imageButton3);
        i_pesquisa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });



        i_filtro = (ImageButton) findViewById(R.id.imageButton);
        i_lista = (ImageButton) findViewById(R.id.imageButton2);
        i_pelada_quadra = (ImageView) findViewById(R.id.imageView);



        peladaButton = (Button) findViewById(R.id.buttonPeladas);
        peladaButton.setOnClickListener(new View.OnClickListener() {        //Icones de activity_buscar se tornam amarelos

            @Override
            public void onClick(View view) {

                mMap.clear(); //Limpa o mapa

                i_pesquisa.setImageResource(R.drawable.pesquisapeladas);
                i_filtro.setImageResource(R.drawable.filtropeladas);
                i_lista.setImageResource(R.drawable.listapeladas);
                i_pelada_quadra.setImageResource(R.drawable.addpelada_1);
                amarelo = 1;


                /**********Banco de Dados das Peladas**************************************************/

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Pelada");
                query.whereExists("nome");
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> list, com.parse.ParseException e) {
                        if (e == null) {

                            parse = new ParseObject("Pelada");
                            parse_aux = new ParseObject("Pelada");
                            int contador = 1;

                            //Marcando no mapa todas as peladas criadas
                            for (int i = 0; i < list.size(); i++) {

                                parse = list.get(i);

                                LatLng pelada_nova = new LatLng(parse.getDouble("latitude"), parse.getDouble("longitude"));

                                contador = 1;
                                for(int j = i+1; j < list.size(); j++){

                                    parse_aux = list.get(j);

                                    if(parse_aux.getDouble("latitude") == pelada_nova.latitude &&
                                       parse_aux.getDouble("longitude") == pelada_nova.longitude){

                                        contador++;
                                        list.remove(j);
                                    }
                                }

                                if(contador == 1) {

                                    mMap.addMarker(new MarkerOptions().position(pelada_nova)
                                            .icon(icon_peladas));
                                }
                                else if(contador == 2){

                                    mMap.addMarker(new MarkerOptions().position(pelada_nova)
                                            .icon(icon_peladas_duas));
                                }
                                else if(contador >= 3){

                                    mMap.addMarker(new MarkerOptions().position(pelada_nova)
                                            .icon(icon_peladas_tres));
                                }

                            }
                        } else {}
                    }

                });

                /***************************************************************************************/


            }
        });



        quadraButton = (Button) findViewById(R.id.buttonQuadras);
        quadraButton.setOnClickListener(new View.OnClickListener() {        //Icones de activity_buscar se tornam vermelhos

            @Override
            public void onClick(View view) {

                mMap.clear(); //Limpa o mapa

                i_pesquisa.setImageResource(R.drawable.pesquisav);
                i_filtro.setImageResource(R.drawable.filtrov);
                i_lista.setImageResource(R.drawable.listav);
                i_pelada_quadra.setImageResource(R.drawable.addquadra1);
                amarelo = 0;


                /***************************Banco de Dados das Quadras********************************/

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Arena");
                query.whereGreaterThan("nota", -1);
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> list, com.parse.ParseException e) {
                        if (e == null) {

                            parse = new ParseObject("Arena");

                            //Marcando no mapa todas as quadras criadas pelo usuario
                            for (int i = 0; i < list.size(); i++) {

                                parse = list.get(i);

                                LatLng arena_nova = new LatLng(parse.getDouble("latitude"), parse.getDouble("longitude"));
                                mMap.addMarker(new MarkerOptions().position(arena_nova)
                                        .icon(icon));
                            }
                        } else {

                        }
                    }

                });

                /*************************************************************************************/


            }
        });



        addPeladaButton = (Button) findViewById(R.id.buttonAddPelada);
        addPeladaButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (amarelo == 0) {
                    CriarQuadraScreen();

                } else if (amarelo == 1) {
                    CriarPeladaScreen();

                }

            }
        });



        homeButton = (Button) findViewById(R.id.button2);
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
        mMap.setMyLocationEnabled(true);

        //Inicializacao do mapa

        // Movendo a camera para posicao default no mapa
        LatLng Brasilia = new LatLng(-15.794028, -47.882536);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Brasilia));



        /**********Banco de Dados das Peladas**************************************************/

        final BitmapDescriptor icon_peladas = BitmapDescriptorFactory.
                fromResource(R.drawable.uma); //Imagem que marca as peladas

        final BitmapDescriptor icon_peladas_duas = BitmapDescriptorFactory.
                fromResource(R.drawable.pel); //Imagem que marca as peladas

        final BitmapDescriptor icon_peladas_tres = BitmapDescriptorFactory.
                fromResource(R.drawable.tres); //Imagem que marca as peladas


        ParseQuery<ParseObject> query = ParseQuery.getQuery("Pelada");
        query.whereExists("nome");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, com.parse.ParseException e) {
                if (e == null) {

                    parse = new ParseObject("Pelada");
                    parse_aux = new ParseObject("Pelada");
                    int contador = 1;

                    //Marcando no mapa todas as peladas criadas
                    for (int i = 0; i < list.size(); i++) {

                        parse = list.get(i);

                        LatLng pelada_nova = new LatLng(parse.getDouble("latitude"), parse.getDouble("longitude"));

                        contador = 1;
                        for(int j = i+1; j < list.size(); j++){

                            parse_aux = list.get(j);

                            if(parse_aux.getDouble("latitude") == pelada_nova.latitude &&
                                    parse_aux.getDouble("longitude") == pelada_nova.longitude){

                                contador++;
                                list.remove(j);
                            }
                        }

                        if(contador == 1) {

                            mMap.addMarker(new MarkerOptions().position(pelada_nova)
                                    .icon(icon_peladas));
                        }
                        else if(contador == 2){

                            mMap.addMarker(new MarkerOptions().position(pelada_nova)
                                    .icon(icon_peladas_duas));
                        }
                        else if(contador >= 3){

                            mMap.addMarker(new MarkerOptions().position(pelada_nova)
                                    .icon(icon_peladas_tres));
                        }

                    }
                } else {}
            }

        });

        /***************************************************************************************/



        /*******************O que ocorre quando um icone do mapa eh clicado*********************/
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
        {

            @Override
            public boolean onMarkerClick(Marker marker) {


                if(amarelo == 1){       //Ao clicar no icone de pelada

                    framelayout2.setVisibility(View.VISIBLE);
                    LatLng posicao = marker.getPosition();  //Pega a posicao do touch


                    /****************List View e mudanca de icones*****************************************/

                    ParseQuery<ParseObject> query = ParseQuery.getQuery("Pelada");
                    query.whereEqualTo("latitude",posicao.latitude);
                    query.whereEqualTo("longitude",posicao.longitude);
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, com.parse.ParseException e) {
                            if (e == null) {

                                parse = new ParseObject("Pelada");
                                ArrayList<HashMap<String, String>> hms =  new ArrayList<>();
                                int qt_peladas = 0;

                                for(int i = 0; i < list.size(); i++){

                                    parse = list.get(i);

                                    HashMap<String, String> hm = new HashMap<String, String>();


                                    hm.put("texto1", "Nome: "+parse.getString("nome"));
                                    hm.put("texto2", "Participantes: "+parse.getString("participantes"));
                                    hm.put("texto3", "Início: "+parse.getString("hoario_inicio"));
                                    hm.put("texto4", "Fim: "+parse.getString("horario_fim"));


                                    hms.add(hm);
                                    qt_peladas++;

                                }

                                if(qt_peladas == 1){

                                    mapa_de_peladas.setImageResource(R.drawable.mapapeladas1);
                                }
                                else if(qt_peladas == 2){

                                    mapa_de_peladas.setImageResource(R.drawable.mapapeladas);
                                }
                                else{

                                    mapa_de_peladas.setImageResource(R.drawable.mapapeladas3);
                                }


                                String[] from = new String[]{"texto1","texto2","texto3","texto4"};

                                int layout = R.layout.item_list;

                                int[] to = new int[]{R.id.t1,R.id.t2,R.id.t3,R.id.t4};

                                ListView lv = (ListView) findViewById(R.id.list);
                                lv.setAdapter(new SimpleAdapter(BuscarActivity.this, hms,layout, from, to));


                    /******************************************************************************************/

                            } else {}
                        }

                    });

                }
                else {              //Ao clicar no icone de quadra

                    framelayout.setVisibility(View.VISIBLE);
                    LatLng posicao = marker.getPosition();



                    ParseQuery<ParseObject> query = ParseQuery.getQuery("Arena");
                    query.whereEqualTo("latitude",posicao.latitude);
                    query.whereEqualTo("longitude",posicao.longitude);
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, com.parse.ParseException e) {
                            if (e == null) {


                                parse = new ParseObject("Arena");
                                parse = list.get(0);


                                namefromparse.setText(parse.getString("nome"));
                                typefromparse.setText(parse.getString("tipo"));


                                if(parse.getBoolean("agua_perto") == true){

                                    agua_icon.setImageResource(R.drawable.aguacv);
                                }
                                if(parse.getBoolean("banheiro_perto") == true){

                                    banheiro_icon.setImageResource(R.drawable.banheiropv);
                                }
                                if(parse.getBoolean("luz_perto") == true){

                                    luz_icon.setImageResource(R.drawable.luzcv);
                                }
                                if(parse.getBoolean("quadra_paga") == true){

                                    gratis_icon.setImageResource(R.drawable.gratisv);
                                }
                                if(parse.getInt("nota") == 2){

                                    bom_icon.setImageResource(R.drawable.bomcv);
                                }



                            } else {}
                        }

                    });


                }

                return true;
            }

        });

        /***************************************************************************************/

    }

    
    public void CriarQuadraScreen(){

        Intent cqs = new Intent(this, CriarQuadraActivity.class);
        startActivity(cqs);
    }


    public void CriarPeladaScreen(){

        Intent cps = new Intent(this, CriarPeladaActivity.class);
        startActivity(cps);
    }



    @Override
    public void onResume(){     //metodo chamado primeiro sempre que a activity eh pausada
        super.onResume();       // e depois volta a ter atividade (botao de voltar da tela)


        /*************Escondendo status bar****************************/
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        /**************************************************************/

    }

}
