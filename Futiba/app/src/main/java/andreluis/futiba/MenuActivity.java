package andreluis.futiba;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.ArrayList;

public class MenuActivity extends Activity {

    private Button buscarButton, fotoButton;
    private Button agendaButton, descobertasButton,peladasButton, configButton;
    String userId;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_menu);


        /********************Barra de menu***********************************************************************/

        // load slide menu items
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        // nav drawer icons from resources
        navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);

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
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
                // Find People
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(0, -1)));
                // Photos
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(0, -1)));
                // Communities, Will add a counter here
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(0, -1), true, "22"));
                // Pages
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(0, -1)));
                // What's hot, We  will add a counter here
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(0, -1), true, "50+"));


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
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
                // Find People
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(0, -1)));
                // Photos
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(0, -1)));
                // Communities, Will add a counter here
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(0, -1), true, "22"));
                // Pages
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(0, -1)));
                // What's hot, We  will add a counter here
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(0, -1), true, "50+"));


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
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
                // Find People
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(0, -1)));
                // Photos
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(0, -1)));
                // Communities, Will add a counter here
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(0, -1), true, "22"));
                // Pages
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(0, -1)));
                // What's hot, We  will add a counter here
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(0, -1), true, "50+"));


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


}
