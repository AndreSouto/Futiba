package andreluis.futiba;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;

import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;

import java.util.ArrayList;

public class MenuActivity extends Activity {

    private Button buscarButton, fotoButton;
    private Button agendaButton, descobertasButton,peladasButton, configButton;
    String userId;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    // slide menu items
    private TypedArray navMenuIconsAvisos, navMenuIconsSuasPeladas, navMenuIconsDescobertas;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //muda a cor do STATUS BAR
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        }



        /********************Barra de menu***********************************************************************/

        // load slide menu items
        // navMenuTitlesAvisos = getResources().getStringArray(R.array.nav_drawer_items_avisos);
        // navMenuTitlesDescobertas = getResources().getStringArray(R.array.nav_drawer_items_descobertas);
        // navMenuTitlesSuasPeladas = getResources().getStringArray(R.array.nav_drawer_items_suaspeladas);

        // nav drawer icons from resources
        //navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);
        navMenuIconsAvisos = getResources().obtainTypedArray(R.array.nav_drawer_icons_avisos);
        navMenuIconsDescobertas = getResources().obtainTypedArray(R.array.nav_drawer_icons_descobertas);
        navMenuIconsSuasPeladas = getResources().obtainTypedArray(R.array.nav_drawer_icons_suaspeladas);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //Impede que o nDrawerLayout abra ao arrastar na tela
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);


        /*******************************************************************************************************/



        /*******Pega a foto de perfil do usuario***************************/

        Profile profile = Profile.getCurrentProfile();
        if (profile != null) {
            userId = Profile.getCurrentProfile().getId();
            ProfilePictureView profilePictureView;
            profilePictureView = (ProfilePictureView) findViewById(R.id.image);
            if(userId != null) {
                profilePictureView.setProfileId(userId);
            }
        }
        /******************************************************************/


        agendaButton = (Button) findViewById(R.id.Avisos);
        agendaButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                /************Construcao dos itens do mDrawerLayout*******************************************************/

                navDrawerItems = new ArrayList<NavDrawerItem>();

                // adding nav drawer items to array
                // Home
                navDrawerItems.add(new NavDrawerItem(navMenuIconsAvisos.getResourceId(0, -1)));
                // Find People
                navDrawerItems.add(new NavDrawerItem(navMenuIconsAvisos.getResourceId(1, -1)));
                // Photos
                navDrawerItems.add(new NavDrawerItem(navMenuIconsAvisos.getResourceId(2, -1)));
                // Communities, Will add a counter here
                navDrawerItems.add(new NavDrawerItem(navMenuIconsAvisos.getResourceId(3, -1)));
                // Pages
                //navDrawerItems.add(new NavDrawerItem(navMenuIconsAvisos.getResourceId(4, -1)));
                // What's hot, We  will add a counter here
               // navDrawerItems.add(new NavDrawerItem(navMenuIconsAvisos.getResourceId(5, -1)));


                // setting the nav drawer list adapter
                adapter = new NavDrawerListAdapter(getApplicationContext(), navDrawerItems);
                mDrawerList.setAdapter(adapter);

                /**********************************************************************************************************/


                mDrawerLayout.openDrawer(mDrawerList);  //Permite que o mDrawerLayout abra ao clicar no botao


            }
        });


        descobertasButton = (Button) findViewById(R.id.Descobertas);
        descobertasButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                /************Construcao dos itens do mDrawerLayout*******************************************************/

                navDrawerItems = new ArrayList<NavDrawerItem>();

                // adding nav drawer items to array
                // Home
                navDrawerItems.add(new NavDrawerItem(navMenuIconsDescobertas.getResourceId(0,-1)));
                // Find People
                navDrawerItems.add(new NavDrawerItem(navMenuIconsDescobertas.getResourceId(1,-1)));
                // Photos
                navDrawerItems.add(new NavDrawerItem(navMenuIconsDescobertas.getResourceId(2,-1)));
                // Communities, Will add a counter here
                navDrawerItems.add(new NavDrawerItem(navMenuIconsDescobertas.getResourceId(3,-1)));
                // Pages
               // navDrawerItems.add(new NavDrawerItem(navMenuIconsDescobertas.getResourceId(4,-1)));
                // What's hot, We  will add a counter here
                //navDrawerItems.add(new NavDrawerItem(navMenuIconsDescobertas.getResourceId(5,-1)));


                // setting the nav drawer list adapter
                adapter = new NavDrawerListAdapter(getApplicationContext(), navDrawerItems);
                mDrawerList.setAdapter(adapter);

                /**********************************************************************************************************/


                mDrawerLayout.openDrawer(mDrawerList);  //Permite que o mDrawerLayout abra ao clicar no botao


            }
        });


        peladasButton = (Button) findViewById(R.id.Agenda);
        peladasButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                /************Construcao dos itens do mDrawerLayout*******************************************************/

                navDrawerItems = new ArrayList<NavDrawerItem>();

                // adding nav drawer items to array
                // Home
                navDrawerItems.add(new NavDrawerItem(navMenuIconsSuasPeladas.getResourceId(0,-1)));
                // Find People
                navDrawerItems.add(new NavDrawerItem(navMenuIconsSuasPeladas.getResourceId(1,-1)));
                // Photos
                navDrawerItems.add(new NavDrawerItem(navMenuIconsSuasPeladas.getResourceId(2,-1)));
                // Communities, Will add a counter here
                navDrawerItems.add(new NavDrawerItem(navMenuIconsSuasPeladas.getResourceId(3,-1)));
                // Pages
               // navDrawerItems.add(new NavDrawerItem(navMenuIconsSuasPeladas.getResourceId(4,-1)));
                // What's hot, We  will add a counter here
                //navDrawerItems.add(new NavDrawerItem(navMenuIconsSuasPeladas.getResourceId(5,-1)));


                // setting the nav drawer list adapter
                adapter = new NavDrawerListAdapter(getApplicationContext(), navDrawerItems);
                mDrawerList.setAdapter(adapter);

                /**********************************************************************************************************/


                mDrawerLayout.openDrawer(mDrawerList);  //Permite que o mDrawerLayout abra ao clicar no botao


            }
        });


        configButton = (Button) findViewById(R.id.imageView4);
        configButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                EditarPerfilScreen();

            }
        });


        fotoButton = (Button) findViewById(R.id.buttonFoto);
        fotoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                PerfilScreen();

            }
        });


        buscarButton = (Button) findViewById(R.id.button);
        buscarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BuscarScreen();

            }
        });

    }


    public void BuscarScreen() {              //Chama a BuscaActivity

        Intent buscarScreen = new Intent(this, BuscarActivity.class);
        startActivity(buscarScreen);
    }

    public void PerfilScreen() {              //Chama a PerfilActivity

        Intent perfilScreen = new Intent(this, PerfilActivity.class);
        startActivity(perfilScreen);
    }

    public void EditarPerfilScreen() {              //Chama a EditarPerfilActivity

        Intent editarPerfilScreen = new Intent(this, EditarPerfilActivity.class);
        startActivity(editarPerfilScreen);
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
