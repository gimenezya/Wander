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

public class ActivityLoginEmailPass extends AppCompatActivity {

    private EditText txtEmailLogin;
    private EditText txtPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_email_pass);
        txtEmailLogin = (EditText) findViewById(R.id.txtEmailLogin);
        txtPassword = (EditText) findViewById(R.id.txtPasswordLogin);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void btnUserLogin_Click(View v){
        final ProgressDialog progressDialog =ProgressDialog.show(ActivityLoginEmailPass.this,"Please wait..","Proccessing..",true);

        (firebaseAuth.signInWithEmailAndPassword(txtEmailLogin.getText().toString(),txtPassword.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()){
                            Toast.makeText(ActivityLoginEmailPass.this,"Login Successful",Toast.LENGTH_LONG).show();
                            Intent i = new Intent(ActivityLoginEmailPass.this,ActivityProfile.class);
                            i.putExtra("Email",firebaseAuth.getCurrentUser().getEmail());
                            startActivity(i);
                        }
                        else{
                            Log.e("Error",task.getException().toString());
                            Toast.makeText(ActivityLoginEmailPass.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();

                        }
                    }
                });

    }
}
