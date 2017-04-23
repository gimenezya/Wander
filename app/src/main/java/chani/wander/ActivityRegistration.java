package chani.wander;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ActivityRegistration extends AppCompatActivity {

    private EditText txtEmailAddress;
    private EditText txtPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        txtEmailAddress = (EditText) findViewById(R.id.txtEmailRegistration);
        txtPassword = (EditText) findViewById(R.id.txtPasswordRegistration);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void btnRegistration_Click(View v){
            final ProgressDialog progressDialog = ProgressDialog.show(ActivityRegistration.this,"Please wait..","Processing..",true);
        (firebaseAuth.createUserWithEmailAndPassword(txtEmailAddress.getText().toString(),txtPassword.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if (task.isSuccessful()){
                    Toast.makeText(ActivityRegistration.this,"Registration successful",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(ActivityRegistration.this,ActivityLoginEmailPass.class);
                    startActivity(i);
                }
                else{
                    Log.e("Error",task.getException().toString());
                    Toast.makeText(ActivityRegistration.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();

                }

            }
        });
    }

}
