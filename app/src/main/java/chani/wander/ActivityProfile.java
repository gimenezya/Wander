package chani.wander;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityProfile extends AppCompatActivity {

    public TextView tvEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvEmail = (TextView) findViewById(R.id.txtEmailProfile);
        tvEmail.setText(getIntent().getExtras().getString("Email"));
    }
}
