package chani.wander;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnRegistration_Click(View v){
        Intent i = new Intent(MainActivity.this,ActivityRegistration.class);
        startActivity(i);
    }

    public void btnLogin_Click(View v){
        Intent i = new Intent(MainActivity.this,ActivityLoginEmailPass.class);
        startActivity(i);
    }

}
