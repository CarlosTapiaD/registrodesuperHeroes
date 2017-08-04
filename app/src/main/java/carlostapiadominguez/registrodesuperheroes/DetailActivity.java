package carlostapiadominguez.registrodesuperheroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras =getIntent().getExtras();
        TextView heroData = (TextView) findViewById(R.id.ingreso);

     /*   String name = extras.getString(MainActivity.NAME);
        String lastName = extras.getString(MainActivity.LAST_NAME_1);
        String nameHero =extras.getString(MainActivity.NAME_HEROC);
        String age = extras.getString(MainActivity.EDADC);
        String address = extras.getString(MainActivity.DIRECCIONC);
        String city = extras.getString(MainActivity.CIUDADC);

       */
        Superheroe superheroe =extras.getParcelable(MainActivity.superHeroData);
        heroData.setText("Nombre completo:\n"+superheroe.cName+" "+superheroe.cLastName+
                "\n\nNombre de heroe:\n"+superheroe.cNameHero+
                "\n\nEdad:\n"+superheroe.cAge+
                "\n \nDireccion:\n"+superheroe.cAddress+
                "\n\nCiudad:\n"+superheroe.cCity);
        /*
        heroData.setText("Nombre completo:\n"+name+" "+lastName+
                "\n\nNombre de heroe:\n"+nameHero+
                "\n\nEdad:\n"+age+
                "\n \nDireccion:\n"+address+
                "\n\nCiudad:\n"+city);
    */
    }
}
