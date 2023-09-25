package tec.ispc.workflix.views;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import tec.ispc.workflix.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import tec.ispc.workflix.views.ui.login.LoginActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button boton = findViewById(R.id.btnLogin);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para pasar a la siguiente actividad
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

}
