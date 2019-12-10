package enis.rnu.checkmyhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import static enis.rnu.checkmyhealth.R.id.imageButton_img;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ImageButton imageButton_img = findViewById(R.id.imageButton_img) ;
        imageButton_img.setOnClickListener (new ImageButton.OnClickListener() {
            public void onClick (View v){
                Intent intent= new Intent(MenuActivity.this,MainActivity2.class) ;
                startActivity(intent);
            }
        });


    }
}
