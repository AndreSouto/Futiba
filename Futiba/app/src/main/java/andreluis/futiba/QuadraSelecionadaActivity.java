package andreluis.futiba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class QuadraSelecionadaActivity extends AppCompatActivity {

    /**
     *A tela activity_quadra_selecionada somente
     *serve para consultar os atributos da quadra.
     *Ao clicar em qualquer parte da tela, a mesma
     *direcionara o app para a tela ActivityBuscar
     *
     **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadra_selecionada);


        RelativeLayout rlayout = (RelativeLayout) findViewById(R.layout.activity_quadra_selecionada);
        rlayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                BuscarScreen();         //No momento que a tela eh clicada, BuscarScreen() eh chamado

            }

        });


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

    public void BuscarScreen() {              //Chama a BuscaActivity

        Intent buscarScreen = new Intent(this, BuscarActivity.class);
        startActivity(buscarScreen);
    }

}
