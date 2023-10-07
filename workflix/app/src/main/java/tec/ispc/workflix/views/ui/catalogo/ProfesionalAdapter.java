package tec.ispc.workflix.views.ui.catalogo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import tec.ispc.workflix.R;
import tec.ispc.workflix.models.Profesional;

public class ProfesionalAdapter extends RecyclerView.Adapter<ProfesionalAdapter.ProfesionalViewHolder> {
    private List<Profesional> profesionales;
    private Context context;

    public ProfesionalAdapter(List<Profesional> profesionales, Context context) {
        this.profesionales = profesionales;
        this.context = context;
    }

    @NonNull
    @Override
    public ProfesionalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_profesional, parent, false);
        return new ProfesionalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfesionalViewHolder holder, int position) {
        Profesional profesional = profesionales.get(position);
        holder.professionalProfession.setText(profesional.getProfesion());
    }

    @Override
    public int getItemCount() {
        return profesionales.size();
    }

    public class ProfesionalViewHolder extends RecyclerView.ViewHolder {

        public Button professionalProfession;

        public ProfesionalViewHolder(@NonNull View itemView) {
            super(itemView);

            professionalProfession = itemView.findViewById(R.id.professionalProfession);

        }
    }
}

