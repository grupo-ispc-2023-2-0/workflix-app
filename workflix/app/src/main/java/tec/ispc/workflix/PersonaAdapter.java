package tec.ispc.workflix;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

import tec.ispc.workflix.models.Persona;

public class PersonaAdapter extends ArrayAdapter<Persona> {
    public PersonaAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Persona> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
