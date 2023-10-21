package tec.ispc.workflix.views.ui.back;

import android.content.Context;

import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

import tec.ispc.workflix.models.Servicio;
import tec.ispc.workflix.models.Usuario;

public class ServicioAdapter extends ArrayAdapter<Servicio> {
    private Context context;
    private List<Servicio>servicios;

    public ServicioAdapter(@NonNull Context context, int resource, @NonNull List<Servicio> objects) {
        super(context, resource, objects);
        this.context = context;
        this.servicios = objects;
    }

}
