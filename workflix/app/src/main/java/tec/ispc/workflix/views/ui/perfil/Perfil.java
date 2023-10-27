package tec.ispc.workflix.views.ui.perfil;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tec.ispc.workflix.R;
import tec.ispc.workflix.models.Usuario;
import tec.ispc.workflix.utils.Apis;
import tec.ispc.workflix.utils.UsuarioService;
import tec.ispc.workflix.views.MainActivity;
import tec.ispc.workflix.views.ui.back.UsuarioActivity;
import tec.ispc.workflix.views.ui.dashboard_admin.DashboardUsuariosActivity;
import tec.ispc.workflix.views.ui.perfil_terminos.PerfilTerminosActivity;

public class Perfil extends AppCompatActivity {
    ImageView imagen;
    private UsuarioService usuarioService;
    private TextView tv_nombre, tv_apellido, tv_correo, tv_telefono, tv_ciudad, tv_profesion, tv_provincia, tv_descripcion, tv_foto;
    private Button sign_out_btn;
    private Button btnEliminarPerfil;
    private Button btnActualizarPerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_perfil);

        // Text views objetos
        tv_nombre = findViewById(R.id.perfilNombre);
        tv_apellido = findViewById(R.id.perfilApellido);
        tv_correo = findViewById(R.id.perfilCorreo);
        tv_telefono = findViewById(R.id.perfilTelefono);
        tv_ciudad = findViewById(R.id.perfilCiudad);
        tv_provincia = findViewById(R.id.perfilProvincia);
        tv_descripcion = findViewById(R.id.perfilDescripcion);
        tv_profesion = findViewById(R.id.perfilServicio);

        btnActualizarPerfil = findViewById(R.id.btnActualizarPerfil);
        btnEliminarPerfil = findViewById(R.id.btnEliminarPerfil);

        imagen = (ImageView) findViewById(R.id.imagenFoto);

        SharedPreferences preferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        String nombre = preferences.getString("nombre", ""); // El segundo parámetro es un valor por defecto si la clave no se encuentra
        String apellido = preferences.getString("apellido", "");
        String correo = preferences.getString("correo", "");
        String telefono = preferences.getString("telefono", "");
        String ciudad = preferences.getString("ciudad","");
        String descripcion = preferences.getString("descripcion","");
        String provincia = preferences.getString("provincia","");
        String profesion = preferences.getString("profesion","");
        int id = preferences.getInt("id",0);


        // Seteo los valores al perfil

        tv_nombre.setText(nombre);
        tv_apellido.setText(apellido);
        tv_telefono.setText(telefono);
        tv_correo.setText(correo);
        tv_ciudad.setText(ciudad);
        tv_descripcion.setText(descripcion);
        tv_provincia.setText(provincia);
        tv_profesion.setText(profesion);



        btnEliminarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_nombre.setText(null);
                tv_apellido.setText(null);
                tv_telefono.setText(null);
                tv_correo.setText(null);
                tv_ciudad.setText(null);
                tv_descripcion.setText(null);
                tv_provincia.setText(null);
                tv_profesion.setText(null);
                deleteUsuario(Integer.valueOf(id));
                // Obtener una referencia a SharedPreferences
                SharedPreferences preferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.remove("id");
                editor.putString("nombre", null);
                editor.putString("apellido", null);
                editor.putString("correo", null);
                editor.putString("telefono", null);
                editor.putString("ciudad", null);
                editor.putString("descripcion", null);
                editor.putString("provincia", null);
                editor.putString("profesion", null);
                editor.remove("is_admin");
                editor.apply();
                Intent intent =new Intent(Perfil.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    btnActualizarPerfil.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setNombre(tv_nombre.getText().toString());
            usuario.setApellido(tv_apellido.getText().toString());
            usuario.setTelefono(tv_telefono.getText().toString());
            usuario.setCorreo(tv_correo.getText().toString());
            usuario.setCiudad(tv_ciudad.getText().toString());
            usuario.setProvincia(tv_provincia.getText().toString());
            usuario.setProfesion(tv_profesion.getText().toString());
            usuario.setDescripcion(tv_descripcion.getText().toString());
            updateUsuario(usuario,Integer.valueOf(id));
            Intent intent =new Intent(Perfil.this, PerfilTerminosActivity.class);
            startActivity(intent);

        }
    });
    }
    public void updateUsuario(Usuario usuario,int id){
        usuarioService= Apis.getUsuarioService();
        Call<Usuario>call=usuarioService.actPerfil(usuario,id);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Perfil.this,"Se Actualizó con éxito su Perfil",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e("Error al actualizar su Perfil:",t.getMessage());
            }
        });
        Intent intent =new Intent(Perfil.this, PerfilTerminosActivity.class);
        startActivity(intent);
    }
    public void deleteUsuario(int id){
        usuarioService= Apis.getUsuarioService();
        Call<Usuario> call=usuarioService.deleteUsuario(id);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Perfil.this,"Se Elimino el registro con éxito",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e("Error al eliminar el Usuario:",t.getMessage());
            }
        });
        Intent intent =new Intent(Perfil.this, MainActivity.class);
        startActivity(intent);
    }

    public void subirFoto(View view) {
    }
}

