package com.saad.gufran.gufranrestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText etemail;
    private EditText etpassword;
    private Button btnSignup;
    private Button btnLogin;
    private Button btnforgot,btnRsturant;;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        etemail = (EditText) findViewById(R.id.etemail);
        etpassword = (EditText) findViewById(R.id.etpassword);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        btnforgot = (Button) findViewById(R.id.btnForgot);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRsturant=(Button) findViewById(R.id.btnRsturant);
        auth= FirebaseAuth.getInstance();
        eventHandler();


//3shan edl faet m7obar
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Intent i1= new Intent(LoginActivity.this,ChoicesActivity.class);
            startActivity(i1);
            finish();

        }

    }

    private void dataHanler() {
        boolean isok=true;

        String stEmail = etemail.getText().toString();
        if (stEmail.length() == 0) {
            etemail.setError("Wrong Email");
            isok = false;
        }
        String stPassword = etpassword.getText().toString();
        if (stPassword.length() == 0) {
            etpassword.setError("Wrong password");
            isok = false;
        }
        if (isok) {

            signIn(stEmail, stPassword);
        }
    }

    private void eventHandler() {
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(LoginActivity.this,SignupActivity.class);

                startActivity(i1);


            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              dataHanler();

            }
        });
        btnforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });
        btnRsturant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),Orders.class));
            }
        });
    }


    private void signIn(final String email, String passw) {
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                    if(email.equals("gufran@gmail.com"))
                    {
                        Intent i= new Intent(LoginActivity.this,Orders.class);
                        startActivity(i);
                    }
                    else {
                        Intent i = new Intent(LoginActivity.this, ChoicesActivity.class);
                        startActivity(i);
                    }

                    // Intent intent=new Intent(LogInActivity.this,MainFCMActivity.class);
                    //   startActivity(intent);
                    //  finish();
                } else {
                    Toast.makeText(LoginActivity.this, "signIn failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }
    private FirebaseAuth.AuthStateListener authStateListener=new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            //4.
            FirebaseUser user=firebaseAuth.getCurrentUser();
            if(user!=null)
            {
                //user is signed in
                Toast.makeText(LoginActivity.this, "user is signed in.", Toast.LENGTH_SHORT).show();

            }
            else
            {
                //user signed out
                Toast.makeText(LoginActivity.this, "user signed out.", Toast.LENGTH_SHORT).show();

            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authStateListener);
    }
    @Override
    protected void onStop() {
        super.onStop();
        if(authStateListener!=null)
            auth.removeAuthStateListener(authStateListener);
    }


    }




