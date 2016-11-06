package com.saad.gufran.gufranrestaurant;

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

public class SignupActivity extends AppCompatActivity {
    private EditText etemail;
    private EditText etpass;
    private EditText etrepass;
    private EditText etName;
    private Button btnSave;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        auth= FirebaseAuth.getInstance();
        etemail = (EditText) findViewById(R.id.etemail);
        etpass = (EditText) findViewById(R.id.etpass);
        etrepass = (EditText) findViewById(R.id.etrepass);
        etName = (EditText) findViewById(R.id.etName);
        btnSave = (Button) findViewById(R.id.btnSave);
        eventHandler();



    }
    private void dataHanler() {
        String stEmail2 = etemail.getText().toString();
        boolean isok=true;

        if (stEmail2.length() == 0) {
            etemail.setError("Wrong Email");
            isok = false;
        }
        String stPass = etpass.getText().toString();

            if (stPass.length() == 0) {
                etpass.setError("Write password");
                isok = false;
            }

        String stName = etName.getText().toString();

            if (stPass.length() == 0) {
                etName.setError("it is not a name");
                isok = false;
            }

        String stRepass = etrepass.getText().toString();

            if (stPass.length() == 0) {
                etrepass.setError("not the same password");
                isok = false;
            }
        if (isok) {
            creatAcount(stEmail2, stPass);
        }




    }
         private void eventHandler(){
             btnSave.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
//                     Intent i2 = new Intent(SignupActivity.this, TasksListActivity.class);
//                     startActivity(i2);
                     dataHanler();





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
                Toast.makeText(SignupActivity.this, "user is signed in.", Toast.LENGTH_SHORT).show();

            }
            else
            {
                //user signed out
                Toast.makeText(SignupActivity.this, "user signed out.", Toast.LENGTH_SHORT).show();

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

    private void creatAcount(String email, String passw) {
        auth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(SignupActivity.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                    //updateUserProfile(task.getResult().getUser());
                    finish();
                }
                else
                {
                    Toast.makeText(SignupActivity.this, "Authentication failed."+task.getException().getMessage(),
                            Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }






                }



