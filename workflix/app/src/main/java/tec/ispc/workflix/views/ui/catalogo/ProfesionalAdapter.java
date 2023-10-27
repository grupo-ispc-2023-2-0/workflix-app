package tec.ispc.workflix.views.ui.catalogo;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tec.ispc.workflix.R;
import tec.ispc.workflix.models.Usuario;
import tec.ispc.workflix.utils.Apis;
import tec.ispc.workflix.utils.UsuarioService;
import tec.ispc.workflix.views.ui.back.UsuarioAdapter;

public class ProfesionalAdapter extends RecyclerView.Adapter {
    UsuarioService usuarioService;
    List<Usuario> listarUsuario = new ArrayList<>();
    ListView listView;
    Context context;

    public ProfesionalAdapter(Context context, ListView listView) {
        this.context = context;
        this.listView = listView;
        listUsuariosNoAdmin();
    }

    public ProfesionalAdapter(List<Usuario> profesionales, CatalogoActivity catalogoActivity, OnUsuarioClickListener onUsuarioClickListener) {

    }

    public void listUsuariosNoAdmin() {
        usuarioService = Apis.getUsuarioService();
        Call<List<Usuario>> call = usuarioService.getUsuarios();

        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if (response.isSuccessful()) {
                    List<Usuario> usuarios = response.body();
                    listarUsuario = filtrarUsuariosNoAdmin(usuarios);
                    listView.setAdapter(new UsuarioAdapter(context, R.layout.content_listar, listarUsuario));
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.e("Error no se puede recuperar Lista de Usuarios", t.getMessage());
            }
        });
    }

    private List<Usuario> filtrarUsuariosNoAdmin(List<Usuario> usuarios) {
        List<Usuario> usuariosNoAdmin = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (!usuario.isIs_admin()) {
                usuariosNoAdmin.add(usuario);
            }
        }
        return usuariosNoAdmin;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface OnUsuarioClickListener {
        void onUsuarioClick(int position);
    }

}
