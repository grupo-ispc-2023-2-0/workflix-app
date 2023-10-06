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
import tec.ispc.workflix.models.Usuario;
import tec.ispc.workflix.utils.UsuarioService;
import tec.ispc.workflix.views.FalsoMain;
import tec.ispc.workflix.views.ui.dashboard_admin.ListarUsuariosActivity;

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
        String nom=bundle.getString("NOMBRES");
        String ape=bundle.getString("APELLIDOS");
        String cla=bundle.getString("CLAVES");
        String tel=bundle.getString("TELEFONO");
        String corr=bundle.getString("CORREO");



        txtId.setText(id);
        txtNombre.setText(nom);
        txtApellido.setText(ape);
        txtClave.setText(cla);
        txtTelefono.setText(tel);
        txtCorreo.setText(corr);

        if(id.trim().length()==0||id.equals("")){
            iduser.setVisibility(View.INVISIBLE);
            txtId.setVisibility(View.INVISIBLE);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario();
                usuario.setNombre(txtNombre.getText().toString());
                usuario.setApellido(txtApellido.getText().toString());
                if(id.trim().length()==0||id.equals("")){
                    addUsuario(usuario);
                    Intent intent =new Intent(UsuarioActivity.this, ListarUsuariosActivity.class);
                    startActivity(intent);
                }else{
                    updateUsuario(usuario,Integer.valueOf(id));
                    Intent intent =new Intent(UsuarioActivity.this, ListarUsuariosActivity.class);
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