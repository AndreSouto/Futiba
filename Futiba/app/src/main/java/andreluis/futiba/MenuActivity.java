package andreluis.futiba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class MenuActivity extends AppCompatActivity {

    private Button buscarButton, fotoButton;
    String userId = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_menu);


        /*******Pega a foto de perfil do usuario***************************/

        userId = Profile.getCurrentProfile().getId();
        ProfilePictureView profilePictureView;
        profilePictureView = (ProfilePictureView) findViewById(R.id.image);
        profilePictureView.setProfileId(userId);

        /******************************************************************/

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
                ParseUser user = new ParseUser();
                user.setUsername("Dudu");
                user.setPassword("Calil");
                BuscarScreen();

            }
        });



    }


    public void BuscarScreen(){              //Chama a BuscaActivity

        Intent buscarScreen = new Intent(this, BuscarActivity.class);
        startActivity(buscarScreen);
    }
    public void PerfilScreen(){              //Chama a BuscaActivity

        Intent perfilScreen = new Intent(this, PerfilActivity.class);
        startActivity(perfilScreen);
    }
}
