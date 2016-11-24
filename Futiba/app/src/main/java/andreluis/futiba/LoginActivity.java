package andreluis.futiba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.parse.Parse;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    private LoginButton loginButton;
    private Button loginNormalButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("3HZSG8lHjzVfdt4Phg9O2uprnJpv5sBB3NGF0cgh")
                .clientKey("9oClZtKqkum9f7dhn73Uy1aCWYuZkWtKjOTvrwYM")
                .server("https://parseapi.back4app.com/").build()
        );

        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);



        //muda a cor do STATUS BAR
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
        }



        FacebookSdk.sdkInitialize(getApplicationContext(), new FacebookSdk.InitializeCallback() {
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

        loginButton = (LoginButton) findViewById(R.id.fb_btn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onfbClick();
            }

        });

        loginNormalButton = (Button) findViewById(R.id.normalLoginButton);
        loginNormalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MenuScreen();
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


    private void onfbClick() {
        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email","public_profile"));
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                AccessToken accessToken = loginResult.getAccessToken();
                Profile profile = Profile.getCurrentProfile();

                Bundle parameters = new Bundle();
                parameters.putString("fields", "first_name,last_name");
                //request.setParameters(parameters);
                //request.executeAsync();
                MenuScreen();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException exception) {

            }
        });
    }

}