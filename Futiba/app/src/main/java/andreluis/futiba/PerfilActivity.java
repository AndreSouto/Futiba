package andreluis.futiba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;

public class PerfilActivity extends AppCompatActivity {

    private int genteBoaMedals;
    private int bomdBolaMedals;
    private boolean jogaGol;
    private String filosofia;
    private String userId = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        /*******Pega a foto de perfil do usuario***************************/

        Profile profile = Profile.getCurrentProfile();
        if (profile != null) {
            userId = Profile.getCurrentProfile().getId();
            ProfilePictureView profilePictureView;
            profilePictureView = (ProfilePictureView) findViewById(R.id.image);
            profilePictureView.setProfileId(userId);
        }

        /******************************************************************/
    }

    //setters:
    public void setFilosofia(String frase) {
        filosofia = frase;
    }

    public void setJogaGol(boolean state) {
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