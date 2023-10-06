package tec.ispc.workflix.views.ui.back;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import tec.ispc.workflix.R;
import tec.ispc.workflix.models.Persona;
import tec.ispc.workflix.utils.UsuarioService;
import tec.ispc.workflix.views.FalsoMain;

public class UsuarioActivity extends AppCompatActivity {
    UsuarioService usuarioService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);


        TextView iduser=(TextView)findViewById(R.id.IdUsuario);
        EditText txtId=(EditText)findViewById(R.id.txtIdUsuario);

        TextView nombre=(TextView)findViewById(R.id.NombreUsuario);
        final EditText txtNombre=(EditText)findViewById(R.id.txtNombre);

        TextView apellido=(TextView)findViewById(R.id.ApellidoUsuario);
        final EditText txtApellido=(EditText)findViewById(R.id.txtApellido);

        TextView clave=(TextView)findViewById(R.id.ClaveUsuario);
        final EditText txtClave=(EditText)findViewById(R.id.txtClave);

        TextView telefono=(TextView)findViewById(R.id.TelefonoUsuario);
        final EditText txtTelefono=(EditText)findViewById(R.id.txtTelefono);

        TextView correo=(TextView)findViewById(R.id.CorreoUsuario);
        final EditText txtCorreo=(EditText)findViewById(R.id.txtCorreo);




        Button btnSave=(Button)findViewById(R.id.btnSave);
        Button btnVolver=(Button)findViewById(R.id.btnVolver);
        Button btnEliminar=(Button)findViewById(R.id.btnEliminar);


        Bundle bundle=getIntent().getExtras();
        final String id = bundle.getString("ID");
        String nom=bundle.getString("NOMBRE");
        String ape=bundle.getString("APELLIDOS");

        txtId.setText(id);
        txtNombres.setText(nom);
        txtApellidos.setText(ape);
        if(id.trim().length()==0||id.equals("")){
            idper.setVisibility(View.INVISIBLE);
            txtId.setVisibility(View.INVISIBLE);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona p=new Persona();
                p.setNombres(txtNombres.getText().toString());
                p.setApellidos(txtApellidos.getText().toString());
                if(id.trim().length()==0||id.equals("")){
                    addPersona(p);
                    Intent intent =new Intent(PersonaActivity.this, FalsoMain.class);
                    startActivity(intent);
                }else{
                    updatePersona(p,Integer.valueOf(id));
                    Intent intent =new Intent(PersonaActivity.this, FalsoMain.class);
                    startActivity(intent);
                }

            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePersona(Integer.valueOf(id));
                Intent intent =new Intent(PersonaActivity.this, FalsoMain.class);
                startActivity(intent);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(PersonaActivity.this, FalsoMain.class);
                startActivity(intent);
            }
        });

    }
}