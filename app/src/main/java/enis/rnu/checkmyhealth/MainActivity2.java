package enis.rnu.checkmyhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    RadioGroup radioGroup  ;

    int sexe ;
    RadioButton radioButton;
    EditText poidsInput ;
    EditText tailleInput ;
    EditText ageInput ;
    ImageButton imgButton ;
    Button btn ;
    TextView description ;
    ImageView imageView ;
    public void init(){
        poidsInput=(EditText) findViewById(R.id.text_poids) ;
        tailleInput=(EditText) findViewById(R.id.text_taille) ;
        ageInput=(EditText) findViewById(R.id.text_age) ;
        RadioGroup radioGroup = findViewById(R.id.radioGroup) ;
        imageView=findViewById(R.id.imageView) ;
        imgButton = findViewById(R.id.Home_btn) ;
        btn=findViewById(R.id.button_calcul);
        description=findViewById(R.id.description) ;

    }
    public void ecoute_btn_calcul(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float poids= Float.valueOf(poidsInput.getText().toString());
                float taille= Float.valueOf(tailleInput.getText().toString());
                float age= Float.valueOf(ageInput.getText().toString());
                float IMC = poids/(taille*taille);
                float IMG = (float) ((1.20*IMC)+(0.23*age)-(10.8*sexe)-5.4);

                if( IMG <15) {
                    description.setTextColor(Color.RED);
                    description.setText("Votre Indice de Masse de Graisse est " + IMG);
                    imageView.setImageResource(R.drawable.maigre);
                }
                else if (IMG > 30 ){
                    description.setTextColor(Color.RED);
                    description.setText("Votre Indice de Masse de Graisse est " + IMG);
                    imageView.setImageResource(R.drawable.graisse);
                }
                else{
                    description.setTextColor(Color.GREEN);
                    description.setText("Votre Indice de Masse de Graisse est " + IMG);
                    imageView.setImageResource(R.drawable.normal);
                }



            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init() ;
        ecoute_btn_calcul();
        ImageButton imageButton_img = findViewById(R.id.Home_btn) ;
        imageButton_img.setOnClickListener (new ImageButton.OnClickListener() {
            public void onClick (View v){
                Intent intent= new Intent(MainActivity2.this,MenuActivity.class) ;
                startActivity(intent);
            }
        });
    }
    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked() ;
        switch(view.getId())
        {
            case R.id.homme_choice:
                if(checked)
                    sexe=1 ;
                break ;
            case R.id.femme_choice:
                if(checked)
                    sexe=0 ;
                break ;
        }
    }
}
