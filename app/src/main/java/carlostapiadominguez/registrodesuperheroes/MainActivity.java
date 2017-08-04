package carlostapiadominguez.registrodesuperheroes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    public static final String superHeroData = "superHeroData";
    private static final int CAMERA_REQUEST_CODE =1000 ;
    ImageView imagenSuper;

    /*  public static final String LAST_NAME_1 = "last_name1";
      public static final String NAME_HEROC = "nameHeroc";
      public static final String EDADC = "edadc";
      public static final String DIRECCIONC = "direccionc";
      public static final String CIUDADC = "ciudadc";
  */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnregistro = (Button) findViewById(R.id.btnRegistrar);


        final EditText nameEdit =(EditText) findViewById(R.id.name);
        final EditText lastNameEdit =(EditText) findViewById(R.id.last_name);
        final EditText nameHeroEdit =(EditText) findViewById(R.id.nameHero);
        final EditText ageEdit =(EditText) findViewById(R.id.edad);
        final EditText addressEdit =(EditText) findViewById(R.id.direccion);
        final EditText cityEdit =(EditText) findViewById(R.id.ciudad);

        imagenSuper = (ImageView) findViewById(R.id.hero);
        imagenSuper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();

            }
        });

        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent (MainActivity.this, DetailActivity.class);
                Superheroe superheroe = new Superheroe(nameEdit.getText().toString(),lastNameEdit.getText().toString(),nameHeroEdit.getText().toString(),ageEdit.getText().toString(),addressEdit.getText().toString(),cityEdit.getText().toString());
                detailIntent.putExtra(superHeroData,superheroe);
             /* detailIntent.putExtra(NAME,superheroe.cName);
                detailIntent.putExtra(LAST_NAME_1,superheroe.cLastName);
                detailIntent.putExtra(NAME_HEROC,superheroe.cNameHero);
                detailIntent.putExtra(EDADC,superheroe.cAge);
                detailIntent.putExtra(DIRECCIONC,superheroe.cAddress);
                detailIntent.putExtra(CIUDADC,superheroe.cCity);
*/
                startActivity(detailIntent);

            }
        });

    }
    private void openCamera(){
        Intent camareIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camareIntent,CAMERA_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE){
            Bundle extras = data.getExtras();
            Bitmap bitmap=(Bitmap) extras.get("data");
            imagenSuper.setImageBitmap(bitmap);
        }
    }
}
