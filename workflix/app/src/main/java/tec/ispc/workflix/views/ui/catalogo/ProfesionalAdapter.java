package tec.ispc.workflix.views.ui.catalogo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import tec.ispc.workflix.R;
import tec.ispc.workflix.models.Profesional;

public class ProfesionalAdapter extends RecyclerView.Adapter<ProfesionalAdapter.ProfesionalViewHolder> {
    private List<Profesional> profesionales;
    private Context context;
    private OnProfesionalClickListener listener;

    public interface OnProfesionalClickListener {
        void onProfesionalClick(int posicion);
    }

    public ProfesionalAdapter(List<Profesional> profesionales, Context context, OnProfesionalClickListener listener) {
        this.profesionales = profesionales;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProfesionalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_profesional, parent, false);
        return new ProfesionalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfesionalViewHolder holder, int position) {
        final int posicion = position; // Guarda la posición para usarla en el onClickListener
        final Profesional profesional = profesionales.get(position);

        // Configurar la profesión
        holder.professionalProfession.setText(profesional.getProfession());

        // Configurar el nombre y apellido
        holder.professionalName.setText(profesional.getNombre() + " " + profesional.getApellido());

        // Configurar la descripción
        holder.professionalDescription.setText(profesional.getDescripcion());

        // Configurar la imagen del profesional
        holder.professionalImage.setImageResource(profesional.getImagenPerfil());

        holder.hireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Utiliza la interfaz de callback para manejar el clic en el botón
                listener.onProfesionalClick(posicion);
            }
        });
    }

    @Override
    public int getItemCount() {
        return profesionales.size();
    }

    public class ProfesionalViewHolder extends RecyclerView.ViewHolder {
        public Button professionalProfession;
        public ImageView professionalImage;
        public TextView professionalName;
        public TextView professionalDescription;
        public Button hireButton;

        public ProfesionalViewHolder(@NonNull View itemView) {
            super(itemView);
            professionalProfession = itemView.findViewById(R.id.professionalProfession);
            professionalImage = itemView.findViewById(R.id.professionalImage);
            professionalName = itemView.findViewById(R.id.professionalName);
            professionalDescription = itemView.findViewById(R.id.professionalDescription);
            hireButton = itemView.findViewById(R.id.hireButton);
        }
    }
}
