package tec.ispc.workflix.views.ui.catalogo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.List;
import tec.ispc.workflix.R;
import tec.ispc.workflix.models.Usuario;
import tec.ispc.workflix.utils.UsuarioService;

public class ProfesionalAdapter extends RecyclerView.Adapter<ProfesionalAdapter.ProfesionalViewHolder> {
    UsuarioService usuarioService;
    List<Usuario> listarUsuario= new ArrayList<>();
    ListView listView;
    public interface OnUsuarioClickListener {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

    }

    private void setContentView(int activityCatalogo) {
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
