package andreluis.futiba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.ToggleButton;

public class EditarPerfilActivity extends AppCompatActivity {

    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);


        /*******Pega a foto de perfil do usuario***************************/
/*
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

        PerfilActivity pf = new PerfilActivity();

        Switch jogaGolSwitch = (Switch) findViewById(R.id.jogaGolSwitch);
        ToggleButton butaoPosicao = (ToggleButton) findViewById(R.id.posicao);
        EditText fraseFilosofica = (EditText) findViewById (R.id.filosofia);


        pf.setFilosofia(fraseFilosofica.getEditableText().toString());

        jogaGolSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pf.setJogaGol(jogaGolSwitch.isChecked());
            }
        });

        butaoPosicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pf.setJogaGol(true);
            }
        });



    }

   // public void jogaGolSwitchChange(Switch jogaGolSwitch) {
   //     PerfilActivity.setJogaGol(jogaGolSwitch.isChecked());
   // }


}
