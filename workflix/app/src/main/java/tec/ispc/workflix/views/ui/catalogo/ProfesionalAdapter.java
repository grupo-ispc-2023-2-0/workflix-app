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
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;
import tec.ispc.workflix.R;
import tec.ispc.workflix.models.Usuario;

public class ProfesionalAdapter extends RecyclerView.Adapter<ProfesionalAdapter.ProfesionalViewHolder> {
    private List<Usuario> usuarios;
    private Context context;
    private OnUsuarioClickListener listener;

    public interface OnUsuarioClickListener {
        void onUsuarioClick(int posicion);
    }

    public ProfesionalAdapter(List<Usuario> usuarios, Context context, OnUsuarioClickListener listener) {
        this.usuarios = usuarios;
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
        final int posicion = position;
        final Usuario usuario = usuarios.get(position);

        holder.professionalName.setText(usuario.getNombre() + " " + usuario.getApellido());

        String servicioUrl = "http://192.168.10.7:8080/servicios/"; // + usuario.getIdServicio();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, servicioUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Maneja la respuesta aquí. En este ejemplo, se asume que la respuesta es un JSON.
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    String nombreServicio = jsonResponse.getString("nombre");

                    holder.professionalProfession.setText(nombreServicio);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Maneja errores si la solicitud falla.
                error.printStackTrace();
            }
        });

        // Agregamos la solicitud a la cola de solicitudes de Volley
        Volley.newRequestQueue(context).add(stringRequest);

        holder.hireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onUsuarioClick(posicion);
            }
        });
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public class ProfesionalViewHolder extends RecyclerView.ViewHolder {
        public TextView professionalProfession;
        public ImageView professionalImage;
        public TextView professionalName;
        public Button hireButton;

        public ProfesionalViewHolder(@NonNull View itemView) {
            super(itemView);
            professionalProfession = itemView.findViewById(R.id.professionalProfession);
            professionalImage = itemView.findViewById(R.id.professionalImage);
            professionalName = itemView.findViewById(R.id.professionalName);
            hireButton = itemView.findViewById(R.id.hireButton);
        }
    }
}
