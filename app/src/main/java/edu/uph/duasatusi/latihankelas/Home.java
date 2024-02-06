package edu.uph.duasatusi.latihankelas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ConstraintLayout todoLayout = (ConstraintLayout) findViewById(R.id.layoutTodo);
        ConstraintLayout profileLayout = (ConstraintLayout) findViewById(R.id.layoutProfile);
        profileLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplication(), ProfileActivity.class);
                Home.this.startActivity(myIntent);
            }
        });
        todoLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplication(), MainActivity.class);
                Home.this.startActivity(myIntent);
            }
        });
    }
}