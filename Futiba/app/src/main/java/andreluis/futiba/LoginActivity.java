package andreluis.futiba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

   // private EditText Login, Senha;
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);


        FacebookSdk.sdkInitialize(getApplicationContext(), new FacebookSdk.InitializeCallback() {   /*******************/
            @Override
            public void onInitialized() {                                                           //Tal funcao garante
                if(AccessToken.getCurrentAccessToken() == null){                                    //que o usuario permaneca
                                                                                                    //com login no facebook

                } else {

                    Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_SHORT).show();
                    MenuScreen();

                }
            }
        });

        callbackManager = CallbackManager.Factory.create();


        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("email"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult){
                
                MenuScreen();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), "Login ou senha incorretos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void MenuScreen(){

        Intent Main = new Intent(this,MenuActivity.class);      //Caso o login de certo, mudar para activity Menu
        startActivity(Main);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}


        //Login = (EditText)findViewById(R.id.editTextLogin);
       // Senha = (EditText)findViewById(R.id.editTextSenha);
/**

        Login.setOnTouchListener(new View.OnTouchListener() {               // Apaga o texto "Login" padrão do edit text
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    Login.setText("");
                }
                return false;
            }
        });

        Senha.setOnTouchListener(new View.OnTouchListener() {              // Apaga o texto "Senha" padrão do edit text
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    Login.setText("");
                }
                return false;
            }
        });

**/
