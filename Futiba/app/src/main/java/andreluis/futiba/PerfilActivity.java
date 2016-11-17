package andreluis.futiba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;

public class PerfilActivity extends AppCompatActivity {

    private int genteBoaMedals;
    private int bomdBolaMedals;
    private static boolean jogaGol;
    private String filosofia;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        //muda a cor do STATUS BAR
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.green));
        }


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

        Switch jogaGolSwitch = (Switch) findViewById(R.id.jogaGolSwitch);
        ToggleButton butaoPosicao = (ToggleButton) findViewById(R.id.posicao);
        EditText fraseFilosofica = (EditText) findViewById (R.id.filosofia);


    }

    //setters:
    public void setFilosofia(String frase) {
        filosofia = frase;
    }

    public static void setJogaGol(boolean state) {
        jogaGol = state;
    }

    public void addGenteBoaMedals() {
        genteBoaMedals++;
    }

    public void addbomdBolaMedals() {
        bomdBolaMedals++;
    }


    //getters:
    public int getBomdBolaMedals() {
        return bomdBolaMedals;
    }

    public int getGenteBoaMedals() {
        return genteBoaMedals;
    }

    public boolean isJogaGol() {
        return jogaGol;
    }

    public String getFilosofia() {
        return filosofia;
    }

}