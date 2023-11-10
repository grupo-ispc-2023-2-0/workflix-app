package tec.ispc.workflix.views.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

import tec.ispc.workflix.R;
import tec.ispc.workflix.views.ui.catalogo.CatalogoActivity;
import tec.ispc.workflix.views.ui.login.LoginActivity;


public class HomeFragment extends Fragment {
    private Button btn_home_servicio;

    private Button btn_home_profesional;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btn_home_profesional = view.findViewById(R.id.btn_home2);
        btn_home_profesional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), CatalogoActivity.class);
                startActivity(intent);
            }
        });

        btn_home_servicio = view.findViewById(R.id.btn_home);
        mostrarElementosHome();

        btn_home_servicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getSharedPreferences("user_data", Context.MODE_PRIVATE);
                boolean isAdmin = preferences.getBoolean("is_admin", /*Valor por defecto nulo:*/ false);
                if (preferences.contains("nombre") && !isAdmin) {
                    Intent intent = new Intent(getActivity(), CatalogoActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        return view;

    }
    public void mostrarElementosHome() {
        SharedPreferences preferences = getActivity().getSharedPreferences("user_data", Context.MODE_PRIVATE);
        boolean isAdmin = preferences.getBoolean("is_admin", /*Valor por defecto nulo:*/ false);
        if (preferences.contains("nombre") && isAdmin) {
            btn_home_servicio.setVisibility(View.GONE);
        }
    }
}
