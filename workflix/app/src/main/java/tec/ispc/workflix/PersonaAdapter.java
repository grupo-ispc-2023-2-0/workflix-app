package tec.ispc.workflix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import tec.ispc.workflix.models.Persona;

public class PersonaAdapter extends ArrayAdapter<Persona> {
    private Context context;
    private List<Persona>personas;
    public PersonaAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Persona> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        this.personas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview = layoutInflater.inflate(R.layout.activity_catalogo,parent,false);

        TextView txtIdPersona =(TextView)rowview.findViewById(R.id.ID);
        TextView txtIdNombre =(TextView)rowview.findViewById(R.id.nombre);
        TextView txtIdApellido =(TextView)rowview.findViewById(R.id.apellido);

    }
}
