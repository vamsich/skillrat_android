package com.skillrat.myapp.authentication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.skillrat.myapp.database.PrefManager;
import com.skillrat.myapp.skillrat.AppIntroActivity;
import com.skillrat.myapp.skillrat.MainActivity;
import com.skillrat.myapp.skillrat.R;

import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Arun1234 on 5/23/2018.
 */

public class LoginActivity extends Activity {
    private static final String TAG = "LoginActivity";
    PrefManager prefManager;
    private static final int REQUEST_SIGNUP = 0;
Button btn_login;
    private LoginButton fbLoginButton;
    private CallbackManager callbackManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        final Context context = this;
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
        callbackManager = CallbackManager.Factory.create();
        prefManager = new PrefManager(LoginActivity.this);
        TextView forgotPwdText = (TextView) findViewById(R.id.link_frgtpwd);
        TextView signupText = (TextView) findViewById(R.id.link_signup);
        TextView skipText = (TextView) findViewById(R.id.skip);
        btn_login= (Button) findViewById(R.id.btn_login);
        fbLoginButton = (LoginButton)findViewById(R.id.login_button);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (prefManager.isFirstTimeLaunch()) {

                    Intent intent = new Intent(context, AppIntroActivity.class);
                    startActivity(intent);
                } else {

                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        forgotPwdText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        skipText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AppIntroActivity.class);
                startActivity(intent);
            }
        });
        fbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("fb loginsuccess","loginresult"+ "User ID: "
                        + loginResult.getAccessToken().getUserId()
                        + "\n" +
                        "Auth Token: "
                        + loginResult.getAccessToken().getToken());

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {

            }
        });
    }
}
