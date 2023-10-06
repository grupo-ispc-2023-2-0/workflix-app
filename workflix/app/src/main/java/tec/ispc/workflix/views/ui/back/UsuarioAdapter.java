package tec.ispc.workflix.views.ui.back;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

import tec.ispc.workflix.R;
import tec.ispc.workflix.models.Usuario;
public class UsuarioAdapter extends ArrayAdapter<Usuario>{
    private Context context;
    private List<Usuario>usuarios;

    public UsuarioAdapter(@NonNull Context context, int resource, @NonNull List<Usuario> objects) {
        super(context, resource, objects);
        this.context = context;
        this.usuarios = objects;
    }
}
