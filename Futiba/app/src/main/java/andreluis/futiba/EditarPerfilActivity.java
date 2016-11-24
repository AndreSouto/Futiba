package andreluis.futiba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.parse.ParseObject;

public class EditarPerfilActivity extends AppCompatActivity {

    private String userId;
    private ParseObject atleta;
    private PerfilActivity pf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        pf = new PerfilActivity();
        /*
        // Colocando as informações do usuário no banco de dados;
         */
        atleta = new ParseObject("Atleta");

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

        final Switch jogaGolSwitch = (Switch) findViewById(R.id.jogaGolSwitch);
        ToggleButton butaoPosicao = (ToggleButton) findViewById(R.id.posicao);
        EditText fraseFilosofica = (EditText) findViewById(R.id.filosofia);
        Spinner spinnerPosicao = (Spinner) findViewById(R.id.spinnerPosicao);

        // Cria um ArrayAdapter usando o string array e o default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.posicoesFut, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Aplica o adapter ao spinner
        spinnerPosicao.setAdapter(adapter);

        pf.setFilosofia(fraseFilosofica.getEditableText().toString());

        // Momento em que usuário clica no botão se joga gol
        jogaGolSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pf.setJogaGol(jogaGolSwitch.isChecked());
                atleta.put("joga_gol", pf.isJogaGol());
            }
        });



        //atleta.put("filosofia", pf.getFilosofia());


    }

    ////////////Função chamada quando um item da lista spinner é clicado //////////////
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        pf.setPosicao(parent.getItemAtPosition(position).toString());
        atleta.put("posicao_campo", pf.getPosicao());

        Toast.makeText(parent.getContext(), "Selected: " + pf.getPosicao(), Toast.LENGTH_SHORT).show();
    }

    //Função chamada quando nada é selecionado
    public void onNothingSelected(AdapterView<?> parent) {
        // Nada
    }

}