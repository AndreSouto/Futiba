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

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class EditarPerfilActivity extends AppCompatActivity {

    private String userId;
    private ParseObject atleta;
    private PerfilActivity pf;
    private EditText fraseFilosofica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        pf = new PerfilActivity();
        /*
        // Colocando as informações do usuário no banco de dados;
         */


        final Switch jogaGolSwitch = (Switch) findViewById(R.id.jogaGolSwitch);
        //ToggleButton butaoPosicao = (ToggleButton) findViewById(R.id.posicao);
        fraseFilosofica = (EditText) findViewById(R.id.filosofia);


        /********************* Funções do Spinner ************************/

        final Spinner spinnerPosicao = (Spinner) findViewById(R.id.spinnerPosicao);

        // Cria um ArrayAdapter usando o string array e o default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.posicoesFut, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Aplica o adapter ao spinner
        spinnerPosicao.setAdapter(adapter);



        /******************************************************************/


        ParseQuery<ParseObject> query = ParseQuery.getQuery("Atleta");
        query.whereEqualTo("nome_completo", "Andre Luis");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {

                    atleta = new ParseObject("Atleta");

                    if(list.size() == 0){

                        atleta.put("nome_completo", "Andre Luis");
                        atleta.saveInBackground();
                    }
                    else {

                        atleta = list.get(0);


                        if (atleta.getBoolean("joga_gol") == true) {

                            jogaGolSwitch.setChecked(true);
                        } else {

                            jogaGolSwitch.setChecked(false);
                        }




                        if(atleta.getString("posicao_campo").equals("Ataque")){

                            spinnerPosicao.setSelection(0);
                        }
                        else if(atleta.getString("posicao_campo").equals("Volante")){

                            spinnerPosicao.setSelection(1);
                        }
                        else if(atleta.getString("posicao_campo").equals("Defesa")){

                            spinnerPosicao.setSelection(2);
                        }



                        fraseFilosofica.setText(atleta.getString("filosofia"));
                        String ID = atleta.getObjectId();


                    }
                } else {

                    atleta = new ParseObject("Atleta");
                    atleta.put("nome_completo", "Andre Luis");
                }
            }
        });


        // Momento em que usuário clica no botão se joga gol
        jogaGolSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pf.setJogaGol(jogaGolSwitch.isChecked());                       //seta o bool no obj.
            }
        });

        // Momento em que o usuário escreve sua filosofia e clica enter
        fraseFilosofica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pf.setFilosofia(fraseFilosofica.getEditableText().toString());  //seta a fil. do obj.
            }
        });


        spinnerPosicao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            ////////////Função chamada quando um item da lista spinner é clicado //////////////
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pf.setPosicao(parent.getItemAtPosition(position).toString());

                Toast.makeText(parent.getContext(), "Selected: " + pf.getPosicao(), Toast.LENGTH_SHORT).show();
            }

            //Função chamada quando nada é selecionado
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //nada
            }
        });

    }

    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first

        atleta.put("joga_gol", pf.isJogaGol());
        atleta.put("posicao_campo", pf.getPosicao());
        atleta.put("filosofia",fraseFilosofica.getText().toString());
        atleta.saveInBackground();

    }

}