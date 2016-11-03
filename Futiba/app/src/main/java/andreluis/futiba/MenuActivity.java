package andreluis.futiba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    //TODO: Inserir foto do facebook ! Criar local REDONDO para foto !

    private Button buscarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buscarButton = (Button) findViewById(R.id.button);

        buscarButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                BuscarScreen();

            }
        });



    }


    public void BuscarScreen(){              //Chama a BuscaActivity

        Intent buscarScreen = new Intent(this, BuscarActivity.class);
        startActivity(buscarScreen);
    }
}
