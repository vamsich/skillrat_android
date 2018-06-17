package com.skillrat.myapp.authentication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.skillrat.myapp.DrawerActivity;
import com.skillrat.myapp.skillrat.MainActivity;
import com.skillrat.myapp.skillrat.R;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by Arun1234 on 5/23/2018.
 */

public class LoginActivity extends Activity
{
    private static final String TAG = "LoginActivity";

    private static final int REQUEST_SIGNUP = 0;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        final Context context= this;
        setContentView(R.layout.activity_login);

        TextView forgotPwdText=(TextView)findViewById(R.id.link_frgtpwd);
        TextView signupText=(TextView)findViewById(R.id.link_signup);
        TextView skipText=(TextView)findViewById(R.id.skip);
        forgotPwdText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent= new Intent(context, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        signupText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent= new Intent(context, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        skipText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent= new Intent(context, DrawerActivity.class);
                startActivity(intent);
            }
        });
    }
}
