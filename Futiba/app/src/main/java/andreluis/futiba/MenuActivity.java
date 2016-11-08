package andreluis.futiba;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;

import java.util.ArrayList;

public class MenuActivity extends Activity {

    private Button buscarButton, fotoButton;
    private ImageButton agendaButton, descobertasButton,peladasButton;
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
            profilePictureView.setProfileId(userId);
        }

        /******************************************************************/


        agendaButton = (ImageButton) findViewById(R.id.imageAvisos);
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


        descobertasButton = (ImageButton) findViewById(R.id.imageDescobertas);
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


        peladasButton = (ImageButton) findViewById(R.id.imageAgenda);
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

    public void PerfilScreen() {              //Chama a BuscaActivity

        Intent perfilScreen = new Intent(this, PerfilActivity.class);
        startActivity(perfilScreen);
    }


}