package tec.ispc.workflix.views.ui.back;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tec.ispc.workflix.R;
import tec.ispc.workflix.models.Persona;
import tec.ispc.workflix.models.Usuario;
import tec.ispc.workflix.utils.Apis;
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
                deleteUsuario(Integer.valueOf(id));
                Intent intent =new Intent(UsuarioActivity.this, ListarUsuariosActivity.class);
                startActivity(intent);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(UsuarioActivity.this, ListarUsuariosActivity.class);
                startActivity(intent);
            }
        });

    }

    public void addUsuario(Usuario usuario){
        usuarioService = Apis.getUsuarioService();
        Call<Usuario> call=usuarioService.addUsuario(usuario);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    Toast.makeText(UsuarioActivity.this,"Se agrego un Usuario con éxito",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e("Error al agregar un Usuario:",t.getMessage());
            }
        });
        Intent intent =new Intent(UsuarioActivity.this, ListarUsuariosActivity.class);
        startActivity(intent);
    }
    public void updateUsuario(Usuario usuario,int id){
        service= Apis.getPersonaService();
        Call<Persona>call=service.updatePersona(p,id);
        call.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, Response<Persona> response) {
                if(response.isSuccessful()){
                    Toast.makeText(PersonaActivity.this,"Se Actualizó con éxito",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
        Intent intent =new Intent(PersonaActivity.this, FalsoMain.class);
        startActivity(intent);
    }
    public void deletePersona(int id){
        service=Apis.getPersonaService();
        Call<Persona>call=service.deletePersona(id);
        call.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, Response<Persona> response) {
                if(response.isSuccessful()){
                    Toast.makeText(PersonaActivity.this,"Se Elimino el registro",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
        Intent intent =new Intent(PersonaActivity.this,FalsoMain.class);
        startActivity(intent);
    }
}