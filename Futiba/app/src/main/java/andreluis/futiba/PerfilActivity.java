package andreluis.futiba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class PerfilActivity extends AppCompatActivity {

    private int genteBoaMedals;
    private int bomdBolaMedals;
    private static boolean jogaGol;
    private String posicao;
    private String filosofia;
    private String userId;
    private ParseObject atleta;

    TextView intMedalhasGB;
    TextView intMedalhasBB;

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


        intMedalhasGB = (TextView) findViewById(R.id.intMedalhasGB);
        intMedalhasBB = (TextView) findViewById(R.id.intMedalhasBB);

        //pega o objeto do parse
        ParseQuery<ParseObject> query = ParseQuery.getQuery("atleta");
        query.whereEqualTo("nome_completo", "Andre Luis");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {

                    atleta = new ParseObject("atleta");

                    setGenteBoaMedals(atleta.getInt("gente_boa"));
                    setBomdBolaMedals(atleta.getInt("bom_de_bola"));
                    setJogaGol(atleta.getBoolean("joga_gol"));
                    setPosicao(atleta.getString("posicao_campo"));
                    setFilosofia(atleta.getString("filosofia"));
                    String ID = atleta.getObjectId();

                } else {
                }
            }
        });

        /*******Pega a foto de perfil do usuario***************************/

        Profile profile = Profile.getCurrentProfile();
        if (profile != null) {
            userId = Profile.getCurrentProfile().getId();
            ProfilePictureView profilePictureView;
            profilePictureView = (ProfilePictureView) findViewById(R.id.fbImage);
            if(userId != null) {
                profilePictureView.setProfileId(userId);
            }
        }

        /******************************************************************/

        Switch jogaGolSwitch = (Switch) findViewById(R.id.jogaGolSwitch);
        //ToggleButton butaoPosicao = (ToggleButton) findViewById(R.id.posicao);
        EditText fraseFilosofica = (EditText) findViewById (R.id.filosofia);

        intMedalhasBB.setText(String.valueOf(getBomdBolaMedals()));
        intMedalhasGB.setText(String.valueOf(getGenteBoaMedals()));

        TextView textPosicao = (TextView) findViewById(R.id.textPosicao);
        textPosicao.setText(getPosicao());
        TextView textJogaGol = (TextView) findViewById(R.id.textJogaGol);
        textJogaGol.setText(jogaGol());
        TextView textFilosofia = (TextView) findViewById(R.id.textFilosofia);
        textFilosofia.setText(getFilosofia());

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

    public void setGenteBoaMedals(int medals) { genteBoaMedals = medals; }

    public void addbomdBolaMedals() {
        bomdBolaMedals++;
    }

    public void setBomdBolaMedals(int medals) { bomdBolaMedals = medals; }

    public void setPosicao (String posicao) {this.posicao = posicao; }

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

    public String jogaGol() {
        if (isJogaGol()) return "SIM";
        else return "NAO";
    }

    public String getFilosofia() {
        return filosofia;
    }

    public String getPosicao () { return posicao; }

}